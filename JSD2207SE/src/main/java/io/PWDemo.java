package io;


import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 缓冲字符流
 * java.io.BufferedWriter和BufferedReader
 * 缓冲字符流可以块读写文本数据加速.
 * <p>
 * java.io.PrintWriter是具有自动行刷新的缓冲字符输出流.内部总是连接BufferedWriter
 * 特点:
 * 1:可以按行写出字符串
 * 2:自动行刷新
 */
public class PWDemo {
        public static void main(String[] args) throws FileNotFoundException {
    //向文件pw.txt中写入文本数据
        /*
            PrintWriter提供了直接对文件进行写操作的构造器:
            PrintWriter(String filename)
            PrintWriter(File file)
            上述两个构造器内部都进行了4层流连接
            PrintWriter->BufferedWriter->OutputStreamWriter->FileOutputStream
            PW:负责按行写出字符串
            BW:块写文本数据加速(内部有一个默认8192长度的字符数组)
            OSW:将写出的字符转字节
            FOS:将字节写入到文件中

         */
        PrintWriter pw = new PrintWriter("pw.txt");
        pw.println("让我再看你一遍,从南到北.");
        pw.println("像是北五环路,蒙住的双眼.");
        System.out.println("写出完毕!");

    }
}
