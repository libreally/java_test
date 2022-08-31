package exception;

/**
 * JAVA 异常处理机制
 * java.lang.Throwable是所有异常的超类，下面派生了两个子类型:
 * Exception:一般表示程序出现的异常，是可恢复的异常。
 * Error:一般表示系统级别的错误，不可恢复。
 * 异常处理机制通常不关心Error。
 *
 * 异常处理机制:
 * try{
 *     代码片段
 * }catch(XXXException e){
 *     try中出现XXXException后的处理代码
 * }
 *
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        //异常处理机制是解决明知道运行可能出现错误但是无法通过逻辑避免的问题(例如断网)
        try {
//            String line = null;
//            String line = "";
            String line = "a";
            System.out.println(line.length());
            System.out.println(line.charAt(0));
            System.out.println(Integer.parseInt(line));
            //try语句块中出错代码以下的内容均不会被执行!
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
            //try中代码不出现下述异常时，catch不会执行
//        }catch(NullPointerException e){
//            System.out.println("出现了空指针并且解决了!");
//        //catch可以定义多个，针对不同异常有不同解决办法时可以分别捕获并处理。
//        }catch(StringIndexOutOfBoundsException e){
//            System.out.println("出现了字符串下标月结并且解决了!");
//        }
        //当多个异常具有相同解决办法时可以合并在一个catch中解决
        }catch(NullPointerException | StringIndexOutOfBoundsException e){
            System.out.println("出现了空指针或下标越界并解决了");
        //使用超类异常可以捕获所有它的子类型异常。如果子类和超类分别有catch的话先先捕获子类型。
        }catch(Exception e){
            System.out.println("反正就是出了个错!");
        }
        System.out.println("程序结束了");

    }
}
