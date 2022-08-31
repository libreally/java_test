package Try_catch_finally;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * try{可能出现异常的代码}
 * catch(异常类型1 变量名1){处理异常方式1}
 * catch(异常类型2 变量名2){处理异常方式2}
 * catch(异常类型3 变量名3){处理异常方式3}
 * catch(异常类型4 变量名4){处理异常方式4}
 * finally{一定会执行的代码}
 *
 * finally是可选的
 * 使用try将可能出现的异常包装起来，在执行过程中一旦出现异常，就会生成对应的异常对象根据此对象的类型，去catch中进行异常处理，处理完成就跳出结构（不包括finally）
 * catch中的异常类型如果没有父子类关系，则顺序无关，若有，则要求子类一定声明在父类上面
 * 常用异常处理方式：String getMessage()   printStackTrace()
 * 在try中声明的变量在外部不可用
 *
 * 使用try-catch-finally处理编译时异常，使得在编译时不出错，但运行时仍可能有错
 * 象数据库连接、输入输出流、socket等资源，jvm是不能自动回收，需要手动资源释放，声明在finally；
 */
public class ExceptionTest1 {
    @Test
    public void test1(){
        String str="123";
        str="abc";
        try {
            int num=Integer.parseInt(str);
        }catch (Exception e){
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        try {
            int a=10;
            int b=0;
            System.out.println(a / b);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("13");
        }
    }
    @Test
    public void test3(){
        FileInputStream fis=null;
        try {
            File file = new File("hello");
            fis=new FileInputStream(file);
            int data=fis.read();
            while (data!=-1){
                System.out.println((char)data);
                data=fis.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis!=null){
                    fis.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
