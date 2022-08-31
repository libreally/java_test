package file;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取./src/main/java/file下所有名字以D开头的子项
 */
public class Test {
    public static void main(String[] args) {
        File dir = new File("./src/main/java/file");
        if(dir.isDirectory()){
            FileFilter filter = new FileFilter() {
                public boolean accept(File file) {
                    String name = file.getName();//获取经过过滤器元素的名字
                    return name.startsWith("D");

                    //获取900字节以下的所有文件
//                    long len = file.length();
//                    return len<=900;
                }
            };
            File[] subs = dir.listFiles(filter);
            for(File sub : subs){
                System.out.println(sub.getName());
            }
        }
    }
}
