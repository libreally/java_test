package ReaderWriter;

import org.junit.jupiter.api.Test;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;

/**
 * 字节输入流 InputStream
 * 字节输出流 OutputStream
 *
 * 字节流用于非文本类型 8bit \字符流用于文本类型 16bit
 *
 * 字符输入流 Reader
 * 字符输出流 Writer
 *
 * 节点流(文件流)                     缓冲流
 * FileInputStream  字节文件输入流    BufferedInputStream
 * FileOutputStream 字节文件输出流    BufferedOutputStream
 * FileReader       字符文件输入流    BufferedReader
 * FileWriter       字符文件输出流    BufferedWriter
 */
public class FileReaderTest {
    /**
     * 文件字符输入流
     * 将文件中的内容读入内存并输出到控制台
     */
    @Test
    public void testFileReader(){
        //1.实例化File对象,指定文件
        File file = new File("hello.txt");
        try(//2.提供流
            FileReader fileReader = new FileReader(file)
        ) {
            //3.读入数据
       /* int read = fileReader.read();//每次读取一个字符，如果已到达流的末尾，则为 -1
        while (read!=-1){
            System.out.print((char) read);//hello world!
            read=fileReader.read();
        }*/
            int read;
            while ((read=fileReader.read())!=-1){
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*//4.关闭流  可使用自动关闭
        fileReader.close();*/
    }

    /**
     * read()重载方法
     */
    @Test
    public void testFileReader1(){
        File file = new File("hello.txt");
        try (FileReader fr=new FileReader(file)){
           char[] cbuf=new char[5];
            //每次读取的字符数，如果已到达流的末尾，则为 -1
            int len;
            while ((len=fr.read(cbuf))!=-1){
               /* for (int i=0;i<len;i++){
                    System.out.print(cbuf[i]);
                }*/
                String s=new String(cbuf,0,len);
                System.out.print(s);
            }


        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
