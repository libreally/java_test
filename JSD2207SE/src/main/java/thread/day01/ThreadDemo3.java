package thread.day01;

/**
 * 匿名内部类创建两种线程
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
       /* Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("查水表");
                }
            }
        };*/
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("查水表");
            }
        });
      /*  Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("who are you ?");
                }
            }
        };*/
        Runnable r2 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("who are you ?");
            }
        };
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}