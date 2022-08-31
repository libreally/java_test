package thread;

/**
 * 多线程的创建方式一：继承与Thread的创建
 * 1.创建继承与thread的子类
 * 2.重写run方法
 * 3.创建thread类的子类的对象
 * 4.通过此对象调用start（）方法
 *
 */
/**
 * 第一种创建线程的优点:结构简单，利于匿名内部类形式创建
 * 缺点:
 * 1:由于java是单继承的，这导致如果继承了线程就无法再继承其他类去复用方法
 * 2:创建线程的同时重写run方法将任务定义在线程中，这导致线程与任务存在必然的耦合关系
 *   不利于线程的重(chong)用。
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1=new MyThread1();
        Thread t2=new MyThread2();
        t1.start();
        t2.start();
    }
}
class MyThread1 extends Thread {
    @Override
    public void run() {
        //将此线程要执行的操作写在里面
        for (int i=0;i<100;i++){
                System.out.println("查水表");

        }
    }
}
class MyThread2 extends Thread {
    @Override
    public void run() {
        //将此线程要执行的操作写在里面
        for (int i=0;i<100;i++){
            System.out.println("开门");

        }
    }
}
