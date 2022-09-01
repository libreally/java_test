package Thread;

/**
 * 例子：三个窗口卖票 总共100张
 *
 * Thread方法
 */
public class WindowTest {

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
            if (ticket > 0) {
                System.out.println(getName() + "卖票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}


