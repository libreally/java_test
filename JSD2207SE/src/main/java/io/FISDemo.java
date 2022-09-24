package io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 使用文件输入流读取文件数据
 */
public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("fos.dat");
        /*
            java.io.InputStream
            定义了基础的读取字节方法
            int read()
            读取一个字节(8位2进制),以int型表示(将读取的字节存入该int值最低八位上),
            并将其返回.如果返回的int值表示整数-1则表示流读取到了末尾.
         */
        /*
            fos.dat文件中的内容:
            00000001 00000101

            第一次调用read方法:
            00000001 00000101
            ^^^^^^^^
            读取的字节

            返回的int值d的2进制样子:
            00000000 00000000 00000000 00000001
            读取到的数据存在低8位上,高24位2进制全部补0
         */
        int d = fis.read();//读取第一个字节
        System.out.println(d);//1

        /*
            fos.dat文件中的内容:
            00000001 00000101

            第二次调用read方法:
            00000001 00000101
                     ^^^^^^^^
                     读取的字节

            返回的int值d的2进制样子:
            00000000 00000000 00000000 00000101
            读取到的数据存在低8位上,高24位2进制全部补0
         */
        d = fis.read();//读取第二个字节
        System.out.println(d);//5

        /*
            fos.dat文件中的内容:
            00000001 00000101

            第三次调用read方法:
            00000001 00000101
                               ^^^^^^^^
                               文件末尾

            返回的int值d的2进制样子:
            11111111 11111111 11111111 11111111
            读取到的数据存在低8位上,高24位2进制全部补0
         */
        d = fis.read();//读取第三个字节(文件只有2个字节,因此第三次读取已经是文件末尾)
        System.out.println(d);//-1

        fis.close();
    }
}
