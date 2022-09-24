package ReaderWriter;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 输出操作.指定文件可不存在,输出时会自动创建此文件
 * 如果存在,则是对文件的覆盖
 * FileWriter  字符文件输出流    BufferedWriter
 * 输出到文件
 */
public class FileWriterTest {
    @Test
    public void testFileWrite() {
        //1.指定文件
        File file = new File("hello.txt");
        //2.指定流 true为开启追加模式,否则为覆盖
        try (FileWriter fw = new FileWriter(file, true)) {
            //3.调用方法
            fw.write("hello world!");
            fw.write("你好世界!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
