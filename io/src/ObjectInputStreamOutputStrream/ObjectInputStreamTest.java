package ObjectInputStreamOutputStrream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象流的使用
 * 作用：用于存储和读取基本数据类型数据或对象的处理流
 */
public class ObjectInputStreamTest {
/**
 * 返序列化
 * 将磁盘文件中的对象还原为内存中的一个java对象
 */
    @Test
    public void testObjectInputStream(){
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Object.dat"))){
            Object o = ois.readObject();
            String s=(String)o;
            System.out.println(s);
            Person person = (Person) ois.readObject();
            System.out.println(person);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
