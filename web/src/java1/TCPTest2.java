package java1;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端发送文件给服务端 服务端将文件保存到本地
 */
public class TCPTest2 {
    @Test
    public void client() {
        try ( Socket socket = new Socket("localhost", 8899);
              OutputStream os = socket.getOutputStream();
              FileInputStream fis=new FileInputStream("image.png")){
            byte[] bytes=new byte[1024];
            int len;
            while ((len=fis.read(bytes))!=-1){
                os.write(bytes,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
    @Test
    public void server() {
        try (ServerSocket serverSocket = new ServerSocket(8899);
             Socket socket = serverSocket.accept();
             InputStream is = socket.getInputStream();
             FileOutputStream fos=new FileOutputStream("image1.png")){
            byte[] bytes=new byte[1024];
            int len;
            while ((len=is.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
