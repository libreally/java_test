package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件复制
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("image.png");
        FileOutputStream fos = new FileOutputStream("image_cp.png");
        int d;//记录每次从原文件中读取的字节
        /*
            image.png的内容:
            10011001 11110000 00001111 01010101 10101010...
            ^^^^^^^^
            d = fis.read()
            d:00000000 00000000 00000000 10011001
            fos.write(d)

            image_cp.png的内容:
            10011001
         */
        long start = System.currentTimeMillis();
        while( (d = fis.read())  != -1 ) {
            fos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕了!耗时:"+(end-start)+"ms");
        fis.close();
        fos.close();
    }
}
