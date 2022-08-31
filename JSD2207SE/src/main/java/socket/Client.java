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
            OutputStream out = socket.getOutputStream();//获取输出流
            OutputStreamWriter osw=new OutputStreamWriter(out, StandardCharsets.UTF_8);//转换流
            BufferedWriter bw=new BufferedWriter(osw);//加速缓冲流
            PrintWriter pw=new PrintWriter(bw,true);//按行写入流
            Scanner scanner=new Scanner(System.in);
            while(true) {
                String line = scanner.nextLine();
                if("exit".equals(line)){
                    socket.close();
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client=new Client();
        client.start();
    }
}
