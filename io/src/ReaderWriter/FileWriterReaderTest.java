package ReaderWriter;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 利用字符输入/输出流实现文本的复制
 */
public class FileWriterReaderTest {
    @Test
    public void test(){
        File file=new File("hello.txt");
        File copyFile=new File("note.txt");
        try(FileReader fr=new FileReader(file);
            FileWriter fw=new FileWriter(copyFile)){
            char[] cbuf=new char[5];
            int len;
            while ((len=fr.read(cbuf))!=-1){
                fw.write(cbuf,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
