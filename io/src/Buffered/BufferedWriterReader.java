package Buffered;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 字符缓冲流
 * BufferedReader
 * BufferedWriter
 */
public class BufferedWriterReader {
    /**
     * 使用字符缓冲流实现文件的复制操作
     */
    @Test
    public void testBufferedWriterReader() {
        try (BufferedReader br = new BufferedReader(new FileReader(new File("hello.txt")));
             BufferedWriter bw = new BufferedWriter(new FileWriter(new File("hello.txt")))) {
            /*char[] chars = new char[10];
            int len;
            while ((len = br.read(chars)) != -1) {
                bw.write(chars, 0, len);
            }*/
            //readLine()按行读取
            String date;
            while((date=br.readLine())!=null){
                bw.write(date+"\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
