package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7之后针对像在IO操作中异常处理机制里关闭流的复杂操作，推出了一个新的特性:
 * 自动关闭特性。可以让我们用更精简的语法处理IO中的异常及关闭操作
 */
public class AutoCloseableDemo {
    public static void main(String[] args) {
        //自动关闭特性是编译器认可的，最终代码会被改为FinallyDemo3的样子
        try(
                //只有实现了AutoCloseable接口的类才可以在这里定义。所有的流都实现了。
                FileOutputStream fos = new FileOutputStream("fos.dat");
        ){
            fos.write(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
