package InputOutputStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件字节输出流
 */
public class FileOutputStreamTest {
    /**
     * 将指定文件复制
     */
    @Test
    public void testFileOutputStream() {
        File srcFile = new File("image.png");//源文件
        File destFile = new File("image1.png");//复制文件
        try (FileInputStream fis = new FileInputStream(srcFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            byte[] bytes = new byte[1024 * 8];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
