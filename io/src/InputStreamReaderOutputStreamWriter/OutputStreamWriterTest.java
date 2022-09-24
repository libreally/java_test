package InputStreamReaderOutputStreamWriter;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 编码:字符数组 字符串-------------->字节 字节数组
 * OutputStreamWriter 将一个字符的输出流转换为字节的输出流
 * 提供字节流与字符流的转换
 */
public class OutputStreamWriterTest {
    @Test
    public void testInputReaderOutputStreamWriter(){
        try (InputStreamReader isr=new InputStreamReader(new FileInputStream("hello.txt"), StandardCharsets.UTF_8);
             OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("hello_gbk.txt"),"gbk")
        ){
            char[] chars=new char[20];
            int len;
            while((len=isr.read(chars))!=-1){
                osw.write(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
