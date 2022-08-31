package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 对象流
 * java.io.ObjectOutputStream和ObjectInputStream
 * 对象流是一对高级流,作用是进行对象序列化与反序列化
 * 对象序列化:将一个java对象按照其结构和内容转换为一组字节的过程.反之为对象反序列化.
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {
        String name = "刘桑";
        int age = 55;
        String gender = "男";
        String[] otherInfo = {"技术好","技术超好","拍片儿技术好","大家技术的启蒙老师"};
        Person p = new Person(name,age,gender,otherInfo);
        System.out.println(p);
        //将person对象写入文件person.obj中
        FileOutputStream fos = new FileOutputStream("person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        /*
            对象输出流提供了序列化对象的方法:
            void write(Object obj)
            该方法会将参数给定的对象按照其结构转换为一组字节后写出.
            需要注意,此方法可能抛出异常:
            java.io.NotSerializableException
            原因:写出的对象没有实现接口:java.io.Serializable
         */
        oos.writeObject(p);
        System.out.println("写出完毕!");
        oos.close();
    }
}
