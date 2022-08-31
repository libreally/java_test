package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换输入流读取文本数据
 */
public class ISRDemo {
    public static void main(String[] args) throws IOException {
        //将当前源代码输出到控制台上
        FileInputStream fis = new FileInputStream(
                "./src/main/java/io/ISRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis);
        /*
            字符流超类Reader上提供了读取字符的方法:
            int read()
            读取一个字符(char),用int形式返回.如果返回的int值为整数-1表示流读取到了末尾
         */
        int d;
        while((d = isr.read()) != -1) {
            System.out.print((char) d);
        }
        isr.close();
    }
}
