package homework.day03;

import java.io.*;

/**
 * 扫描指定目录中的所有.java文件，并将内容全部输出到控制台
 * 
 * 例如将当前项目目录下src/io目录中的所有java文件内容输出
 * 到控制台
 * 
 * 1:先要定位./src/io目录(哪个API用来描述目录?)
 * 2:获取该目录下的所有.java文件
 * 3:遍历每一个java文件，然后按行读取里面的每一行字符串
 *   并输出控制台
 * 
 * 
 * @author Xiloer
 *
 */
public class Test03 {
    public static void main(String[] args) throws IOException {
        File dir = new File("./src/homework/day03");
        File[] subs = dir.listFiles(f->f.getName().endsWith(".java"));
        for(int i=0;i<subs.length;i++){
            File sub = subs[i];
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(sub)));
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        }
    }

}
