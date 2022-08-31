package socket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static java.lang.System.exit;

/**
 * 聊天室服务端
 */
public class Server {
    private ServerSocket serverSocket;
    public Server(){
        try {
            System.out.println("正在启动服务端。。。");
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
                Socket socket = serverSocket.accept();//accept()接收客户端请求
                System.out.println("一个客户端连接了...");
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

    private class ClientHandler implements Runnable{
        private Socket socket;
        private  String host;//记录客户端
        public ClientHandler(Socket socket) {
            this.socket=socket;
            host = socket.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();//输入流
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);//字节转换流 流链接
                BufferedReader br = new BufferedReader(isr);//缓冲流
                String message;//读取信息
                while ((message = br.readLine()) != null) {
                    System.out.println(host+"客户端：" + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
