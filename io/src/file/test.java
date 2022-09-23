package file;

import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.IOException;

public class test {
    @Test
    public void test() throws IOException {
        File file=new File("./hello.txt");

        File file1=new File(file.getParent(),"haha.txt");
        if (file1.exists()){
            System.out.println("cunzai");
        }else {
            file1.createNewFile();
            System.out.println("scccess");
        }
    }

    /**
     * 判断指定文件目录下是否含有.jpg的文件
     */
    @Test
    public void test1(){
        File list=new File("D:\\abc\\java_test\\io");
        String[] list1 = list.list();
        for (String filename:list1){
            if (filename.endsWith(".jpg")){
                System.out.println(filename);
            }
        }
    }
    @Test
    public void test2(){

    }

}
