package thread;

public class ThreadDemo2 {
    public static void main(String[] args) {
        //单独实例化
        Runnable r1=new MyRunnable1();
        Runnable r2=new MyRunnable2();
        //创建线程
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.start();
        t2.start();
    }
}
class MyRunnable1 implements  Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("查水表");
        }
    }
}
    class MyRunnable2 implements  Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("你是谁");
            }
        }
}