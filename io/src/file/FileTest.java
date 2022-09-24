package file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

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
        File file1 = new File("D:\\abc\\java_test\\io\\notenote.txt");//绝对路径
        System.out.println(file);
        System.out.println(file1);
        //2.创建文件方式2
        File file2=new File("D:\\abc\\java_test\\io", "ReaderWriter");
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
        File file2 = new File("D:\\abc\\java_test\\io\\note.txt");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
        System.out.println();
        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getName());
        System.out.println(file2.getPath());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(new Date(file2.lastModified()) );
        System.out.println();
    }
    @Test
    public void test3(){
        File file = new File("D:\\java\\java_test\\io");
        //获取指定目录下的所有文件或文件目录的名称数据
        String[] list=file.list();
        for (String s:list) {
            System.out.println(s);
        }
        File[] files=file.listFiles();
        for (File f:files) {
            System.out.println(f);
        }
    }

    /**
     * boolean renameTo(File dest)
     * 把文件重命名为指定文件名
     */
    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\abc\\java_test\\io\\hh.txt");

        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);

    }

    /**
     * 判断功能
     *         file.isFile(); 是否是文件
     *         file.isDirectory();是否是目录
     *         file.exists();是否存在
     *         file.canWrite();是否可写
     *         file.canRead();是否可读
     *         file.isHidden();是否隐藏
     */
    @Test
    public void test5(){
        File file = new File("hello.txt");
        boolean file1 = file.isFile();
        System.out.println("file1 = " + file1);
        boolean directory = file.isDirectory();
        System.out.println("directory = " + directory);
        boolean exists = file.exists();
        System.out.println("exists = " + exists);
        boolean write = file.canWrite();
        System.out.println("write = " + write);
        boolean read = file.canRead();
        System.out.println("read = " + read);
        boolean hidden = file.isHidden();
        System.out.println("hidden = " + hidden);
    }
    /**
     *  boolean createNewFile()   创建文件 若存在不创建
     *  boolean mkdir()   创建文件目录，若存在不创建 如果此文件的上层不存在则不创建
     *  boolean mkdirs()  创建文件目录，如果上层文件目录不存在，一并创建
     *  boolean delete()   删除文件或文件夹
     */
    @Test
    public void test6() throws IOException {
        File file=new File("hi.txt");
        if (file.exists()){
            file.createNewFile();
            System.out.println("success");
        }else {
            System.out.println("fail");
        }
        File file1=new File("D:\\abc\\java_test\\io\\io\\h2.txt");
        //boolean mkdir = file1.mkdir();//此时上层目录不存在不能创建,应该使用mkdirs
        boolean mkdirs = file1.mkdirs();
        System.out.println("mkdirs="+mkdirs);

    }


}
