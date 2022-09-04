package Thread2;

/**
 * 例子：三个窗口卖票 总共100张
 *
 * Thread方法 同步方法解决线程
 */
public class ThreadDemo {

    public static void main(String[] args) {
        window w1 = new window();
        window w2 = new window();
        window w3 = new window();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();

    }
}

class window extends Thread {
    private static int ticket = 100;
    @Override
    public void run() {
        while (true) {
               show();
        }
    }
    private static synchronized void show(){//同步监视器为当前类ThreadDemo
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
            ticket--;
        }
    }
}


