package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 实现简易记事本
 * 要求:
 * 程序启动后,将用户在控制台上输入的每一行字符串都写入文件note.txt中.
 * 当用户单独输入"exit"时程序退出.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("note.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始输入内容,单独输入exit退出");
        while(true) {
            String line = scanner.nextLine();
//            if(line.equals("exit")){
            if("exit".equalsIgnoreCase(line)){
                break;
            }
            fos.write(line.getBytes(StandardCharsets.UTF_8));
        }
        fos.close();
    }
}
