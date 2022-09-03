package ext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Server {
    List<PrintWriter> allOut=new ArrayList<>();
    private ServerSocket serverSocket;

    public Server() {
        try {
            System.out.println("正在启动服务端...");
            serverSocket = new ServerSocket(8088);
            System.out.println("服务端启动完毕!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            while (true) {
                System.out.println("等待客户端连接...");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端连接了!");
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private String host;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            host = socket.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {
            PrintWriter pw=null;
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                OutputStream os=socket.getOutputStream();
                OutputStreamWriter osw=new OutputStreamWriter(os);
                BufferedWriter bw=new BufferedWriter(osw);
                pw=new PrintWriter(bw,true);
                synchronized (allOut){
                    allOut.add(pw);
                }
                System.out.println(host+"当前人数："+allOut.size());
                String message;
                while ((message = br.readLine()) != null) {
                    System.out.println(host + "客户端:" + message);
                    synchronized (allOut){
                        for (PrintWriter o:allOut){
                            o.println(host + "说:" + message);
                        }
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                synchronized (allOut){
                    allOut.remove(pw);
                }
                System.out.println(host+"下线，当前人数："+allOut.size());
                try {
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
