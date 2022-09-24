package InputOutputStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节流 处理非文本文件
 */
public class FileInputStreamTest {
    @Test
    public void testFileInputStream(){
        File file = new File("hello.txt");
        try(FileInputStream fis=new FileInputStream(file)){
            byte[] bytes=new byte[1024*8];
            int len;
            while ((len=fis.read(bytes))!=-1){
                String s=new String(bytes,0,len);
                System.out.print(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
