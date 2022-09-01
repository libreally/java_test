package thread;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Thread t1 = new Thread(){
            public void run(){
                for(int i=0;i<100;i++){
                    synchronized (list) {
                        list.add(i);
                    }
                }
                System.out.println("添加完毕");
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                for(int i=0;i<100;i++){
                    synchronized (list){
                    list.add(i);
                    }
                }
                System.out.println("添加完毕");
            }
        };
        t1.start();
        t2.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
