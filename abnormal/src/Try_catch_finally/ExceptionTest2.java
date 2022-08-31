package Try_catch_finally;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**异常处理2  throws + 异常类型
* throws + 异常类型  写在方法声明处，指明此方法时，可能会抛出的异常类型
 * 一旦方法体执行时，出现异常，仍会在异常代码处生成一个异常类的对象，此对象满足异常类时就会被抛出，异常后面的代码不在运行
 *
**/
public class ExceptionTest2 {
    public static void main(String[] args) {
        try {
            method2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void method2() throws FileNotFoundException,IOException{
        method1();
    }

    public static void method1() throws FileNotFoundException, IOException {

        File file = new File("hello");
        FileInputStream fis = new FileInputStream(file);
        int data = fis.read();
        while (data != -1) {
            System.out.println((char) data);
            data = fis.read();
        }
        fis.close();
    }
}
