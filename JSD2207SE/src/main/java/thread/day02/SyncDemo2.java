package thread.day02;

/**
 * 同步块
 * 有效缩小同步范围可以保证并发安全前提下尽可能的提高并发效率
 * synchronized () {}
 */
public class SyncDemo2 {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Thread t1 = new Thread("传奇") {
            @Override
            public void run() {
                shop.buy();
            }
        };
        Thread t2 = new Thread("克晶") {
            @Override
            public void run() {
                shop.buy();
            }
        };

        t1.start();
        t2.start();
    }
}

class Shop {
    public void buy() {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "挑衣服");
            Thread.sleep(5000);
            /**
             * 同步块使用时要指定同步监视器对象，该对象的选取要同时满足：
             * 1.必须是一个引用类型实例
             * 2.多个需要同步执行该代码片段的线程看到该对象必须是同一个
             */
            synchronized (this) {
                System.out.println(t.getName() + "试衣服");
                Thread.sleep(5000);
            }

            System.out.println(t.getName() + "结账");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
