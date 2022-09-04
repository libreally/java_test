package Thread2;

/**
 * Runnable接口
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w=new Window2();

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
class Window2 implements Runnable{
    private int ticket=100;
    @Override
    public void run() {
        while (true) {
            show();
        }
    }
    private synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
            ticket--;
        }
    }
}