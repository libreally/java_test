package abnormal.exest;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 异常体系结构
 * java.lang.Throwable
 *       |=--Error一般不针对编写代码进行处理
 *       |---Exception可进行异常处理
 *          |----编译异常：
 *                 |----IOException'
 *                      |----FileNotFoundException
 *                 |----ClassNotFoundException
 *          |----运行异常
 *                 |----NullPointerException 空指针异常
 *                 |----ArrayIndexOutOfBoundsException 数组角标越界
 *                 |----ClassCastException类型转换异常
 *                 |----NumberFormatException数字格式异常
 *                 |----InputMismatchException 使用scanner
 *                 |----ArithmeticException 算数异常
 *
 */
public class ExceptionDemo {
    /************编译时异常*************/

    //FileNotFoundException
    @Test
    public void test7() {
        /*File file = new File("hello.txt");
        FileInputStream fis=new FileInputStream(file);*/
    }

    /************运行时异常*************/
    //ArithmeticException 算数异常
    @Test
    public void test6() {
    /*  int a=10;
      int b=0;
        System.out.println(a/b);*/
    }

    //InputMismatchException 使用scanner
    //输入不是整数的数据时出现
    @Test
    public void test5() {
      /*  Scanner sc=new Scanner(System.in);
        int score= sc.nextInt();;
        System.out.println(score);*/
    }

    //NumberFormatException数字格式异常
    @Test
    public void test4() {
        /*String str="123";
        str = "abc";
        int num=Integer.parseInt(str);*/
    }

    //ClassCastException类型转换异常
    @Test
    public void test3() {
        /*Object str=new Date();
        String str1=(String) str;*/
    }

    //ArrayIndexOutOfBoundsException 数组角标越界
    @Test
    public void test2() {
      /*  int[] arr=new int[10];
        System.out.println(arr[10]);
        String str="abc";
        System.out.println(str.charAt(3));*/
    }

    //NullPointerException 空指针异常
    @Test
    public void test1() {
      /*  int[] arr = null;
        System.out.println(arr[i]);
        String str="abc";
        str=null;
        System.out.println(str.charAt(0));*/

    }

}