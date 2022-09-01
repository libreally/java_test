package socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

/**
 * 聊天室服务端
 */
public class Server {

    List<PrintWriter> allOut=new ArrayList<>();
    private ServerSocket serverSocket;
    public Server(){
        try {
            System.out.println("正在启动服务端。。。");
             /*
                创建ServerSocket的同时要申请服务端口，该端口不能与系统其他程序
                开启的端口一致，否则会抛出异常:
                java.io.BindException:address already in use
                解决办法:
                更换端口
                或
                杀死占用该端口的程序进程:实际开发中8088很少被占用，通常都是由于我们
                启动了两次服务端导致的(第一次启动已经占用了8088，那么第二次启动时
                端口会显示被占用)

             */
            serverSocket=new ServerSocket(8088);
            System.out.println("服务端启动完毕。。。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            while(true){
                System.out.println("等待客户端连接。。。");
                /*
                ServerSocket提供的一个重要方法:
                Socket accept()
                该方法是一个阻塞方法，调用会程序会卡住，直到一个客户端与服务端建立连接
                为止，此时返回的Socket就可与连接的客户端进行交互了。
             */
                Socket socket = serverSocket.accept();//accept()接收客户端请求
                System.out.println("一个客户端连接了...");
                //启动一个线程处理与该客户端的交互
                ClientHandler handler=new ClientHandler(socket);
                Thread t=new Thread(handler);
                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Server server=new Server();
        server.start();
    }
    /**
     * 将处理客户端交互的操作在单独的线程上进行，这里的主要工作就是与某个客户端交互。
     */
    private class ClientHandler implements Runnable{
        private Socket socket;
        private  String host;//记录客户端ip

        public ClientHandler(Socket socket) {
            this.socket=socket;
            host = socket.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {
            PrintWriter pw = null;
            try {
                /*
                    通过Socket获取输入流可以读取来自远端计算机发送过来的消息
                 */
                InputStream in = socket.getInputStream();//输入流
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);//字节转换流 流链接
                BufferedReader br = new BufferedReader(isr);//缓冲流

                //通过socket获取输出流用于给客户端发发消息
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);//转换流
                BufferedWriter bw = new BufferedWriter(osw);//加速缓冲流
                pw = new PrintWriter(bw, true);
                synchronized (allOut) {
                    allOut.add(pw);
                }
                System.out.println(host + "上线了,当前在线人数：" + allOut.size());


                String message;//读取信息
                /*
                    这里循环读取客户端发送过来消息这里可能出现下面的异常:
                    java.net.SocketException: Connection reset
                    这个错误是由于远端异常断开导致的(没有进行TCP的挥手断开操作)，该异常无法通过
                    逻辑避免。
                 */
                while ((message = br.readLine()) != null) {
                    System.out.println(host + "客户端：" + message);
                    //将消息回复给所有客户端
                    synchronized (allOut) {
                        for (PrintWriter o : allOut) {
                            o.println(host + "说" + message);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //处理客户端断开
                synchronized (allOut) {
                    allOut.remove(pw);//删除集合共享数据
                }
                System.out.println(host+"下线了,当前人数:"+allOut.size());
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
