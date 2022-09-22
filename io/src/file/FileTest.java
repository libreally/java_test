package file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 *
 * File类的使用 表示一个文件或文件目录的抽象路径
 * 存在与java.io.
 */
public class FileTest {
    /**
     * 创建File的实例
     */
    @Test
    public void test(){
        //1.创建文件方式1
        File file = new File("hello.txt");//相对路径
        File file1 = new File("D:\\abc\\java_test\\io\\he.txt");//绝对路径
        System.out.println(file);
        System.out.println(file1);
        //2.创建文件方式2
        File file2=new File("D:\\abc\\java_test\\io","io");
        System.out.println(file2);
        //3.创建文件方式3
        File file3 = new File(file2,"test.txt");
        System.out.println(file3);
    }
    /**
     * File文件  获取的方法使用
     * String getAbsolutePath()获取绝对路径
     * String getPath() 获取路径
     * String getName()获取名称
     * String getParent() 获取上层文件
     * long length() 获取文件长度（字节数）
     * long LastModified() 获取最后一次修改时间
     * String[] list() 获取指定目录下的所有文件或文件目录的名称数据
     * File[] listFiles() 获取指定目录下的所有文件或文件目录的File数组
     */
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\abc\\java_test\\io\\he.txt");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
    }
}
