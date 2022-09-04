package Thread2;

/**
 * 同步机制解决线程安全问题
 * 1.同步代码块
 * synchronized(同步监视器){
 * 同步监视器：（锁）任何一个类的对象都可以充当锁 要求多个线程公用同一个锁
 * 需要被同步代码 操作共享数据的代码
 * 共享数据：多个线程共同操作的数据
 * }
 * 2.同步方法
 * 如果操作共享数据的代码完成的声明在一个方法中则将这个方法同步
 */
public class WindowRunnable {
    public static void main(String[] args) {
        Window11 w=new Window11();

        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);

        t1.setName("1");
        t2.setName("2");
        t3.setName("3");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Window11 implements Runnable{
    private int ticket=100;

    @Override
    public void run() {
        while (true) {
            synchronized(this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}