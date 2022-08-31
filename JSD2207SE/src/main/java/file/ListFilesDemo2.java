package file;

import java.io.File;
import java.io.FileFilter;

/**
 * 有条件的获取一个目录中的部分子项
 */
public class ListFilesDemo2 {
    public static void main(String[] args) {
        //需求:获取./src/main/java/file目录中所有名字中含有字母"F"的子项
        File dir = new File("./src/main/java/file");
        if(dir.isDirectory()){
            FileFilter filter = new FileFilter() {
                /*
                    重写accept方法用来定义过滤器的过滤规则。
                    重写规则:
                    将参数file当作将来经过该过滤器的一个元素，当该元素符合过滤器
                    要求时，accept方法应当返回true，表示该元素被过滤器接受。否则
                    返回false。
                 */
                public boolean accept(File file) {
                    String name = file.getName();//获取经过过滤器元素的名字
//                    return name.indexOf("F")!=-1;
                    return name.contains("F");
                }
            };
            File[] subs = dir.listFiles(filter);//回调模式
            for(File sub : subs){
                System.out.println(sub.getName());
            }
        }
    }
}
