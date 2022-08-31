package file;

import java.io.File;
import java.io.IOException;

/**
 * 使用File创建一个新文件
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        //在当前项目目录下新建一个文件test.txt
//        File file = new File("./test.txt");
        //在相对路径中"./"可以忽略不写的。默认就是从"./"开始
        File file = new File("test.txt");
        //如果创建文件时指定的目录不存在则会抛出异常:java.io.IOException: 系统找不到指定的路径。
//        File file = new File("./a/test.txt");
        /*
            boolean exists()
            判断当前File表示的文件或目录是否真实存在。若存在则返回true否则返回false

            exists:存在
            create:创建
         */
        if(file.exists()){
            System.out.println("该文件已存在！");
        }else{
            file.createNewFile();//alt+enter(回车) 选第一项Add exception....
            System.out.println("文件已创建!");
        }

    }
}
