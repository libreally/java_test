package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 缓冲输出流的缓冲区问题
 */
public class FlushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        String line = "super idol的笑容,都没你的甜.";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        bos.write(data);
        /*
            flush方法是接口Flushable中定义的唯一的抽象方法.
            而输出流的超类:java.io.OutputStream实现了该接口,这意味着所有的输出流
            都有这个方法.
            求他高级流的flush方法实现就是调用其连接的流的flush,目的是将flush动作传递
            下去直到调用到了缓冲输出流的flush才会真实清空缓冲区写出.
         */
        bos.flush();
        System.out.println("写出完毕");
        //缓冲流的close方法中会自动调用一次flush().
        bos.close();
    }
}





