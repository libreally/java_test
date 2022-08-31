package homework.day01;

import java.io.File;
import java.io.FileFilter;

/**
 * 列出当前目录中所有名字包含s的子项。
 * 
 * 使用匿名内部类和lambda两种写法
 * 
 * 单词记一记:
 * FileFilter   文件过滤器
 * accept       接受
 * 
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		File dir=new File(".");
		if(dir.isDirectory()){
			File[] suns=dir.listFiles(file -> file.getName().contains("s"));
			for (File sun : suns) {
				System.out.println(sun.getName());
			}
		}
	}
}
/*
	提示代码:
	需要用到的语句，尝试按照正确顺序将下列代码并放在main方法中完成需求，
	并在注释中标注每句话的作用，

	File dir = new File(".");
	if(dir.isDirectory()){
	File[] suns = dir.listFiles(new FileFilter() {
		public boolean accept(File file) {
		return file.getName().contains("s");
		}
	});
	}
	for(int i=0;i<subs.length;i++){
		System.out.println(subs[i].getName());
	}



 */