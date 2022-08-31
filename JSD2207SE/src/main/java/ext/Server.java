package ext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    private ServerSocket serverSocket;
    public Server (){
        try {
            serverSocket=new ServerSocket(8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            while(true){
                Socket socket=serverSocket.accept();
                InputStream in=socket.getInputStream();
                InputStreamReader isr=new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br=new BufferedReader(isr);
                String message;
                while((message= br.readLine())!=null){
                    System.out.println(message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server=new Server();
        server.start();
    }
}
