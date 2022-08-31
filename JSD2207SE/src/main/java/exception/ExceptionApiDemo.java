package exception;

/**
 * 异常常用的方法
 */
public class ExceptionApiDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");

        try {
            String str = "abc";
            System.out.println(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            System.out.println("出错了");
            /*
                错误信息的输出和System.out.println的输出是并发的，
                因此在控制台上看到的顺序可能与执行顺序不一致
             */
            e.printStackTrace();//输出错误堆栈信息，便于定位问题出现的位置和原因
            //错误消息多用于提示给用户的信息或记录日志时使用
            String message = e.getMessage();//获取错误消息
            System.out.println(message);
        }

        System.out.println("程序结束了");
    }
}
