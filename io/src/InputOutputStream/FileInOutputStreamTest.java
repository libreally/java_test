package InputOutputStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOutputStreamTest {
    /**
     *
     * 指定路径下的文件复制的方法
     */
    public void copyFile(String  srcPath,String destPath){

        try (FileInputStream fis = new FileInputStream(srcPath);
             FileOutputStream fos = new FileOutputStream(destPath)) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
        long start = System.currentTimeMillis();
        copyFile("image.png","image2.png");
        long end = System.currentTimeMillis();
        System.out.println(end-start);//5ms
    }
}
