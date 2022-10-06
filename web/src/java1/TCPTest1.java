package java1;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 实现tcp的网络编程
 * 客户端发送内容给服务端 服务端将内容打印到控制台上
 */
public class TCPTest1 {
    @Test
    public void client() {

        try (
                //1.创建socket对象，指定服务器的ip和端口号
                Socket socket = new Socket(InetAddress.getLocalHost(), 8899);
                //2.获取输出流，用于输出数据
                OutputStream outputStream = socket.getOutputStream()) {
            //3.发送数据
            outputStream.write("你好世界".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void server() {
        try (//1.创建ServerSocket对象，用来指定服务器的端口号
                ServerSocket serverSocket = new ServerSocket(8899);
                //2.调用accept()方法，接收客户端发送的请求
                Socket accept = serverSocket.accept();
                //3.获取输入流，用于读取数据
                InputStream inputStream = accept.getInputStream()) {

            byte[] bytes = new byte[1024];
            int date;
            while ((date = inputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, date);
                System.out.println(s);//将读到的数据输入控制台
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
