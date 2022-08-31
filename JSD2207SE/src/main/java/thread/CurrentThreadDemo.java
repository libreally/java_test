package thread;
/**
 * java中所有的代码都是靠线程运行的，main方法也不例外。执行main方法的线程称为"主线程"
 *
 * Thread提供了一个静态方法:
 * static Thread currentThread()
 * 该方法可以获取运行这个方法的线程
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread main=Thread.currentThread();//获取方法的线程
        System.out.println("main = " + main);
    }
    public static void dosome(){
        Thread t=Thread.currentThread();
        System.out.println("t = " + t);
    }
}