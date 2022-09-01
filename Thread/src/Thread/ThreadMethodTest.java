package Thread;

/**
 * Thread常用方法
 * start()启动线程调用run（）
 * run()重写thread类中的方法
 * currentThread（）静态方法，返回当前代码块执行的线程
 * getName（）获取线程名
 * setName（）设置线程名
 * yield()释放当前CPU的执行权
 * join（） 加入正在执行的线程，指导加入的线程执行完毕才继续原来的线程
 * sleep(millis)在指定时间内线程处于阻塞状态
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1=new HelloThread();
        h1.setName("线程1");
        h1.start();
        Thread.currentThread().setName("主线程");
        for (int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }

}
class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if(i%2==0){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
            if (i%20==0){
                this.yield();
            }
        }
    }
}