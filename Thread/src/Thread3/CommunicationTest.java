package Thread3;

/**
 * 线程通信
 */
class Number implements Runnable{
    private int number=1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();//唤醒线程
                if (number<=100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                    try {
                        //使进程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        Number number=new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("1");
        t2.setName("2");
        t1.start();
        t2.start();
    }
}

