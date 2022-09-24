package otherStream;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * 其它流
 * 1.标准的输入输出流
 * 2.打印流
 * 3.数据流
 */
public class OtherStreamTest {
    /**
     * 1.标准的输入输出流
     * 从键盘输入数据 并转大小写,当输入中出现e 或 exit 时退出
     */

    public static void main(String[] args) {
        try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ){
            while (true){
                System.out.println("输入字符串:");
                String data=br.readLine();
                if ("e".equalsIgnoreCase(data)||"exit".equalsIgnoreCase(data)){
                    System.out.println("结束");
                    break;
                }
                String s = data.toUpperCase();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字节打印流 printStream
     * 字符打印流 printWriter
     */
    @Test
    public void printStream(){
        try(FileOutputStream fos=new FileOutputStream("hello.txt");
            PrintStream ps=new PrintStream(fos, true)){
            if (ps!=null){
                System.setOut(ps);//重新设置打印位置
            }
            //输出Ascii码
            for (int i=0;i<=255;i++){
                System.out.println((char)i);
                if (i % 50 == 0){
                    System.out.println();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * 数据流 DataOutputStream
     * DataInputStream
     */
    @Test
    public void DataOutputStreamTest(){
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream("he.txt"))){
            dos.writeUTF("某某某");
            dos.flush();
            dos.writeInt(123);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * 数据流 DataOutputStream
     * DataInputStream
     */
    @Test
    public void DataInputStreamTest(){
        try(DataInputStream dis=new DataInputStream(new FileInputStream("he.txt"))){
            String s = dis.readUTF();
            int i = dis.readInt();
            boolean b = dis.readBoolean();
            System.out.println(s+i+b);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
