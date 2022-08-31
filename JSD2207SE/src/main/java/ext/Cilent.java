package ext;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cilent {
    private Socket socket;
    public Cilent(){
        try {
            socket=new Socket("localhost",8088);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try{
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
}
