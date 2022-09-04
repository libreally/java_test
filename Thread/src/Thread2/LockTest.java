package Thread2;

import java.util.concurrent.locks.ReentrantLock;

//lock解决线程安全问题
class Window implements Runnable{
    private int ticket=100;
    //1.实例化ReentrantLock
    private ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                //调用lock（）
                lock.lock();
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
            }finally{
                //解锁
                lock.unlock();
            }
        }
    }
}
public class LockTest {
}
