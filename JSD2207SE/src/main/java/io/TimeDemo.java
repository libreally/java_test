package io;

public class TimeDemo {
    public static void main(String[] args) {
        //UTC:世界协调时
        //long返回的是自1970年1月1日00:00:00到当前系统时间经过的毫秒值
        long now = System.currentTimeMillis();
        System.out.println(now);
        System.out.println(now/1000/60/60/24/365);

        long max = Long.MAX_VALUE;
        max = max/1000/60/60/24/365;
        System.out.println("公元:"+(1970+max));
    }
}
