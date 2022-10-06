package ObjectInputStreamOutputStrream;

import org.junit.jupiter.api.Test;

import java.io.*;

public class ObjectOutputStreamTest {
    /**
     * 序列化过程：将内存中的java对象存储到磁盘中或通过网络传输出去
     * 使用ObjectOutputStream实现
     */
    @Test
    public  void testOutputStream(){
        try( ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Object.dat"))){
            oos.writeObject(new String("我爱北京天安门！"));
            oos.flush();
            oos.writeObject(new Person("王珂",33));
            oos.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
