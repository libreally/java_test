package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 异常处理机制在IO中的应用
 */
public class FinallyDemo3 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("fos.dat");
            fos.write(1);
        } catch (IOException e) {
            System.out.println("出错了!");
        } finally {
            try {
                if(fos!=null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
