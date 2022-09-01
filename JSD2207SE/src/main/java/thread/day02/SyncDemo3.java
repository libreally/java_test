package thread.day02;

public class SyncDemo3 {
    public static void main(String[] args) {
        Foo f1=new Foo();
        Foo f2=new Foo();
        Thread t1= new Thread(() -> Foo.dosome());
        Thread t2= new Thread(() -> Foo.dosome());
        t1.start();
        t2.start();
    }
}
/*
        如果这里将static去掉会如何?
        此时dosome变成一个成员方法，因此synchronized对应的锁对象就是this。
        那么上面两个线程t1和t2调用时由于:
        t1调用的是f1.dosome()，那么dosome中的this就是f1
        t2调用的是f2.dosome()，那么dosome中的this就是f2
        由于两个线程看到的并非同一个锁对象，因此可以同时执行该该方法。

        static方法则不同，由于该方法全局唯一，因此无论什么时候以何种方式调用
        都能做到同步效果(多个线程分开执行)。
     */
class Foo{
    public synchronized static void dosome(){
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+":正在执行dosome方法...");
            Thread.sleep(5000);
            System.out.println(t.getName()+":执行dosome方法完毕!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}