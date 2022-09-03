package ext;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cilent {
    private Socket socket;
    public Cilent(){
        try {
            System.out.println("正在连接服务端...");
            socket=new Socket("localhost",8088);
            System.out.println("与服务端建立连接!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try{
            ServerHandler handler=new ServerHandler();
            Thread t=new Thread(handler);
            t.setDaemon(true);
            t.start();;

            OutputStream out=socket.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw=new BufferedWriter(osw);
            PrintWriter pw=new PrintWriter(bw,true);
            Scanner scanner=new Scanner(System.in);
            while(true){
                String line=scanner.nextLine();
                if ("exit".equals(line)){
                    break;
                }
                pw.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Cilent cilent=new Cilent();
        cilent.start();
    }
    private class ServerHandler implements Runnable{
        @Override
        public void run() {
            try {
                InputStream in=socket.getInputStream();
                InputStreamReader isr=new InputStreamReader(in);
                BufferedReader br=new BufferedReader(isr);
                String message;
                while((message= br.readLine())!=null){
                    System.out.println("message = " + message);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
