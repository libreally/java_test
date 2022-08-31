package thread;

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