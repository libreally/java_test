package file;

import java.io.File;

/**
 * 创建目录
 */
public class MkDirDemo {
    public static void main(String[] args) {
        //在当前项目目录下新建一个目录(文件夹)demo
//        File dir = new File("demo");
        File dir = new File("a/b/c/d/e/f");
        if(dir.exists()){
            System.out.println("该目录已存在");
        }else{
            /*
                make:做
                directory:目录

                mkdir()创建目录是要求该目录所在的目录必须存在,否则无法创建
                mkdirs()创建目录时会将所有不存在的父目录一同创建出来,推荐使用.
             */
//            dir.mkdir();
            dir.mkdirs();
            System.out.println("该目录已创建!");
        }
    }
}





