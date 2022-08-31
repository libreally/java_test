package thread;

import java.util.Scanner;

public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("程序开始");
        Scanner scanner = new Scanner(System.in);
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
