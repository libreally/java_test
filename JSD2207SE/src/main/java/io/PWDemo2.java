package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 使用流连接完成PW的创建
 */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
            PrintWriter->BufferedWriter->OutputStreamWriter->FileOutputStream
            PW:负责按行写出字符串
            BW:块写文本数据加速(内部有一个默认8192长度的字符数组)
            OSW:将写出的字符转字节
            FOS:将字节写入到文件中
         */
        FileOutputStream fos = new FileOutputStream("pw.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        /*
            PrintWriter如果第一个参数为流，那么就支持再传入一个参数为boolean值。
            如果这个值为true则是打开了自动行刷新功能。
         */
        PrintWriter pw = new PrintWriter(bw,true);
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始输入内容,单独输入exit退出");
        while(true) {
            String line = scanner.nextLine();
            if("exit".equalsIgnoreCase(line)){
                break;
            }
            /*
                当PW开启了自动行刷新后，每当我们调用一次println方法后就会自动flush.
             */
            pw.println(line);
        }
        pw.close();

    }
}
