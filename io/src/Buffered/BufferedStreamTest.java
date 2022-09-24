package Buffered;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 字节缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * 作用:提供读写速度  内部提供了缓冲区
 */
public class BufferedStreamTest {
    //实现文件复制
    @Test
    public void BufferedStreamTest() {
        //1.指定文件
        File srcFile = new File("image.png");
        File destFile = new File("image3.png");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //2.使用节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //3.使用缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //4.读写过程
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis!=null){bis.close();}
                if (bos!=null){bos.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
