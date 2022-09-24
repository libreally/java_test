package InputStreamReaderOutputStreamWriter;

import org.junit.jupiter.api.Test;


import java.io.*;
import java.nio.charset.StandardCharsets;


/**
 * 解码: 字节 字节数组------------->字符数组 字符串
 * 转换流(字符)
 * InputStreamReader 将一个字节的输入流转换为字符的输入流
 */
public class InputStreamReaderTest{
    @Test
    public void testInputStreamReader(){
        //字符集的设置取决于文件的属性
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("hello.txt"), StandardCharsets.UTF_8)
        ) {
            char[] chars=new char[1024];
            int len;
            while ((len=isr.read(chars))!=-1){
                String s=new String(chars,0,len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
