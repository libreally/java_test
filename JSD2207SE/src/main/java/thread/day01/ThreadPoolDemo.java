package thread.day01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for(int i=0;i<5;i++){
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    Thread t=Thread.currentThread();
                    System.out.println(t.getName()+"执行任务");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPool.execute(runnable);
        }
        threadPool.shutdown();
    }
}
