package homework.day02;

import java.io.*;

/**
 * 改正下面程序的错误
 * 
 * 程序实现需求:使用缓冲流完成文件的复制操作
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) throws IOException {
			FileInputStream fis = new FileInputStream("test.txt");
		   BufferedInputStream bis = new BufferedInputStream(fis,1024*10);

	       FileOutputStream fos = new FileOutputStream("test_cp.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);

	int d;
	if((d = bis.read())==-1) {
		bos.write(d);
	}
	System.out.println("复制完毕!");
		bis.close();
		bos.close();
	}

}
