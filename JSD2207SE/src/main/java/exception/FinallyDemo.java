package exception;

/**
 * finally是异常处理机制的最后一块
 * 它可以直接跟在try语句块之后或者最后一个catch之后。
 * finally可以保证只要程序执行到try语句块中，无论try中的代码是否出现异常，finally都
 * 必定执行。
 * 所以通常我们将释放资源这类操作放在finally中确保执行，比如IO操作后的关闭。
 */
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try {
            String line = "null";
            System.out.println(line.length());
            return;
        } catch (Exception e) {
            System.out.println("出错了");
        } finally {
            System.out.println("finally中的代码执行了");
        }

        System.out.println("程序结束了");
    }
}












