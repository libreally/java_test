package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 当我们提高每次读写的数据量减少实际读写次数就可以提高读写效率
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("image.png");
        FileOutputStream fos = new FileOutputStream("image_cp2.png");
        /*
            在InputStream和OutputStream两个超类上定义了块读写操作
            InputStream上定义的块读取方法:
            int read(byte[] data)
            一次性读取给定的字节数组data总长度的字节量并存入到该数组中,返回值为实际读取
            到的数据量.如果返回值为-1则表达流读取到了末尾.

            image.png图片数据(假设文件有5个字节):
            10011001 11110000 00001111 01010101 10101010

            byte[] data = new byte[3];//创建一个3字节长度的数组
            int d;

            第一次调用:
            d = fis.read(data);//因为data数组长度是3字节,因此一次最多读取3个字节
            读取文件数据:
            10011001 11110000 00001111 01010101 10101010
            ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
            将读取到的3个字节装入到数组data中
            data:{10011001, 11110000, 00001111}
            d:3 整数3表示本次确实读取到了3个字节

            第二次调用:
            d = fis.read(data);//因为data数组长度是3字节,因此一次最多读取3个字节
            读取文件数据:
            10011001 11110000 00001111 01010101 10101010
                                       ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
                                       实际读取2个字节      文件末尾
            将读取到的2个字节装入到数组data中
            data:{01010101, 10101010, 00001111}
                 |本次读取的2个字节内容| |-旧数据-|
            d:2 整数2表示本次确实读取到了2个字节
            通过返回值d我们可以得知data数组中从第一个字节开始的连续多少个字节是本次实际内容

            第三次调用:
            d = fis.read(data);//因为data数组长度是3字节,因此一次最多读取3个字节
            读取文件数据:
            10011001 11110000 00001111 01010101 10101010
                                                         ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
                                                         文件末尾
            本次已经是文件末尾了,实际上没有读取到任何字节
            data:{01010101, 10101010, 00001111} 数组无变化
                 |------------旧数据-----------|
            d:-1 整数-1表示流已经读取到末尾了



            OutputStream中定义了块写操作对应的方法:
            void write(byte[] data)
            一次性将给定数组中的所有字节写出

            void write(byte[] data,int offset,int len)
            一次性将给定的字节数组data中从下标offset处开始的连续len个字节写出
         */
        byte[] data = new byte[1024*10];//10kb
        int d;//记录每次实际读取到的字节量

        long start = System.currentTimeMillis();
        while((d = fis.read(data)) != -1){
            fos.write(data,0,d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕了!耗时:"+(end-start)+"ms");

        fis.close();
        fos.close();
    }
}


