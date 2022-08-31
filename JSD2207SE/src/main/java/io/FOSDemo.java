package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JAVA IO
 * I:INPUT 输入
 * O:OUTPUT 输出
 * java用方向输入与输出划分读写操作，其中输入用来读取，输出用来写出。
 * java将读写具象比喻为"流"，这里可以想象为"水流"，是向着同一侧顺序移动的过程。
 * 并且流可以理解为是连接我们程序与另一端的“管道”(好比水管)，只不过这个管道中流动的是字节。
 *
 * java.io.InputStream 输入流，是所有输入流的超类，定义了读取字节的相关方法
 * java.io.OutputStream 输出流，是所有输出流的超类，定义了写出字节的相关方法。
 * 我们将来连接不同的设备就可以用不同的流来完成。
 *
 * 文件流:
 * java.io.FileInputStream和FileOutputStream。是专门用来连接程序与文件之间的管道
 * 用来读写文件数据的流。他们分别继承自InputStream和OutputStream
 *
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        //向文件fos.dat中写入字节
        FileOutputStream fos = new FileOutputStream("./fos.dat");
        /*
            java.io.OutputStream定义的写操作:
            void write(int d)
            出1个字节，写出的是给定的int值对应的2进制的"低八位"
                                       vvvvvvvv
            00000000 00000000 00000000 00000001

            fos.dat文件中内容:
            00000001
         */
        fos.write(1);
        /*
                                       vvvvvvvv
            00000000 00000000 00000000 00000101
            fos.dat文件中内容:
            00000001 00000101
         */
        fos.write(5);
        System.out.println("写出完毕!");
        fos.close();
    }
}
