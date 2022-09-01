package thread.day01;

/**
 * 线程的优先级
 * 线程有10个优先级分别用整数1-10表示。其中1是最低，10是最高，5是默认值。
 * 当一个线程调用start后便纳入到了线程调度器中被统一管理。线程只能被动的被分配时间片得以
 * 并发运行，不能主动索取时间片。通过调整线程的优先级可以最大程度的改变获取时间片的概率。
 * 在同一个CPU核心中并发执行的线程中优先级越高的线程获取时间片的次数越多。
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread(){
            public void run(){
                for(int i=0;i<10000;i++){
                    System.out.println("min");
                }
            }
        };
        Thread norm = new Thread(){
            public void run(){
                for(int i=0;i<10000;i++){
                    System.out.println("nor");
                }
            }
        };
        Thread max = new Thread(){
            public void run(){
                for(int i=0;i<10000;i++){
                    System.out.println("max");
                }
            }
        };
        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);
        min.start();
        norm.start();
        max.start();
    }
}
