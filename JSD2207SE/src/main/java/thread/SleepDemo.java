package thread;

import java.util.Scanner;
/**
 * sleep阻塞
 * 线程提供了一个静态方法:
 * static void sleep(long ms)
 * 该方法可以让执行这个方法的线程进入阻塞状态(BLOCK状态)指定毫秒，超时后线程会自动回
 * 到RUNNABLE状态再次开始并发执行
 */
public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("程序开始");
        Scanner scanner = new Scanner(System.in);
        /*
            做一个简易倒计时程序
            要求:程序启动后输入一个数字，从该数字开始每秒递减并输出，当到0时输出时间到
         */
        System.out.println("输入倒计时时间：");
        int n = scanner.nextInt();
        System.out.println("计时开始");
        for (int i = n; i >= 0; i--) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("时间到");
    }
}
