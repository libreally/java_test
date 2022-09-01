package thread.day02;

/**
 * 多线程并发安全问题
 * 当多个线程并发操作同一临界资源由于线程切换时机不确定，导致执行顺序出现混乱从而导致不良后果
 * 临界资源:操作该资源的完成过程同一时刻只能被单一线程进行的。
 */
public class SyncDemo {
    public static void main(String[] args) {
        Table table = new Table();
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    int bean = table.getBeans();//从桌子上拿一个豆子
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    int bean = table.getBeans();//从桌子上拿一个豆子
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    int bean = table.getBeans();
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }

}

class Table {
    private int beans = 20;

    /**
     * synchronized 同步方法
     * 将并发线程改为同步
     * @return
     */
    public synchronized int getBeans() {
        if (beans == 0) {
            throw new RuntimeException("没豆了");
        }
        Thread.yield();//主动放弃剩余时间片
        return beans--;
    }
}