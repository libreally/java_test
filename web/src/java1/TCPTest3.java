package java1;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 客户端发送文件给服务端 服务端将文件保存到本地，并返回给客户端“发送成功”
 */
public class TCPTest3 {
    @Test
    public void client(){
        try(Socket socket=new Socket("localhost",8899);
            OutputStream os=socket.getOutputStream();
            FileInputStream fis=new FileInputStream("image.png")) {
            byte[] bytes=new byte[1024];
            int len;
            while ((len=fis.read(bytes))!=-1){
                os.write(bytes,0,len);
            }
            //关闭数据输出
            socket.shutdownOutput();

            InputStream is = socket.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] b=new byte[1024];
            int len1;
            while ((len1=fis.read(b))!=-1){
                baos.write(b,0,len1);
            }
            System.out.println(baos.toString(StandardCharsets.UTF_8));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @Test
    public void server(){
        try (ServerSocket serverSocket = new ServerSocket(8899);
             Socket socket = serverSocket.accept();
             InputStream is = socket.getInputStream();
             FileOutputStream fos = new FileOutputStream("image2.png")){
            byte[] bytes=new byte[1024];
            int len;
            while ((len=is.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
            OutputStream os = socket.getOutputStream();
            os.write("接收成功".getBytes());

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
