package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
    聊天室客户端
 */
public class Client {
    private Socket socket;
    public Client(){
        try {
            System.out.println("正在连接。。。");
            socket = new Socket("localhost",8088);
            System.out.println("已建立连接。。。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            //启动用来读取服务器的消息的线程
            ServerHandler handler=new ServerHandler();
            Thread t=new Thread(handler);
            t.setDaemon(true);//守护线程，不给服务器发信息时，此线程同时结束
            t.start();
            //向服务器发送消息
            OutputStream out = socket.getOutputStream();//获取输出流
            OutputStreamWriter osw=new OutputStreamWriter(out, StandardCharsets.UTF_8);//转换流
            BufferedWriter bw=new BufferedWriter(osw);//加速缓冲流
            PrintWriter pw=new PrintWriter(bw,true);//按行写入流
            Scanner scanner=new Scanner(System.in);
            while(true) {
                String line = scanner.nextLine();
                if("exit".equals(line)){
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();//关闭连接
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client=new Client();
        client.start();
    }
    private class ServerHandler implements Runnable{
        @Override
        public void run() {
            try {
                /*通过Socket获取输入流可以读取来自服务器发送过来的消息*/
                InputStream in = socket.getInputStream();//输入流
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);//字节转换流 流链接
                BufferedReader br = new BufferedReader(isr);//缓冲流

                String message;
                while ((message = br.readLine()) != null) {
                    System.out.println(message);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
