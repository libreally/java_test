package DataTimeTest;

import org.junit.jupiter.api.Test;

import java.util.Date;


public class DataTimeTest {
    @Test
    public void test1(){
        long time=System.currentTimeMillis();
        //返回的是当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差 称为时间戳
        System.out.println(time);
    }
    @Test
    public void test2(){
        Date date=new Date();//当前时间
        System.out.println(date.toString());//Sun Sep 04 20:59:39 CST 2022 当前时间年份
    }
}
