package Thread;

/**
 * 创建多线程方式2
 * 1.创建实现runnable的接口的子类
 * * 2.重写run方法
 * * 3.创建实现类的对象
 * * 4.将此对象作为参数传入Thread类的构造器中，创建Thread类对象
 * * 5.通过Thread调用start（）
 */
public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        t1.start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}