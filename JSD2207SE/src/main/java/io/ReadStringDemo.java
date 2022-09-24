package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 读取文本文件
 */
public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
        //将当前源代码输出到控制台上
        File file = new File("./src/main/java/io/ReadStringDemo.java");
//        File file = new File("fos.txt");
        FileInputStream fis = new FileInputStream(file);
        long len = file.length();//获取文件大小(字节量)

        byte[] data = new byte[(int)len];
        fis.read(data);//一次性将文件所有字节读入数组data中
        //String的构造方法可以将一个字节数组中的所有字节按照给定的字符集还原为字符串
        String line = new String(data, StandardCharsets.UTF_8);
        System.out.println(line);

        fis.close();
    }
}
