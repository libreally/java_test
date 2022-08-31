package thread;

public class ThreadInfoDemo {
    public static void main(String[] args) {
        Thread main=Thread.currentThread();
        String name=main.getName();//获取线程名
        System.out.println("name = " + name);

        long id=main.getId();//获取唯一标识
        System.out.println("唯一标识 " + id);

        int priority=main.getPriority();//获取优先级
        System.out.println("priority = " + priority);

        boolean isAlive = main.isAlive();//是否活着
        System.out.println("isAlive = " + isAlive);


        boolean daemon = main.isDaemon();//是否为守护线程
        System.out.println("daemon = " + daemon);

        boolean interrupted = main.isInterrupted();//是否被中断
        System.out.println("interrupted = " + interrupted);

    }
}
