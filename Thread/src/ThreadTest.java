/**
 * 多线程的创建方式一：继承与Thread的创建
 * 1.创建继承与thread的子类
 * 2.重写run方法
 * 3.创建thread类的子类的对象
 * 4.通过此对象调用start（）方法
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        t1.start();

    }

}
class MyThread extends Thread {
    @Override
    public void run() {
        //将此线程要执行的操作写在里面
        for (int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}