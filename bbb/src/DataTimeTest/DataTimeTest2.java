package DataTimeTest;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTimeTest2 {
    @Test
    public void test() {
        //实例化SimpleDateFormat  默认构造
        SimpleDateFormat sdf=new SimpleDateFormat();
        Date date=new Date();
        System.out.println(date.toString());//Mon Sep 05 21:39:24 CST 2022
        //格式化时间
        String format = sdf.format(date);
        System.out.println(format);//2022/9/5 下午9:39
        //字符串--------》日期
        String str="2022/9/5 下午9:39";
        try {
            Date parse = sdf.parse(str);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //带参构造
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = simpleDateFormat.format(date);
        System.out.println(format1);
    }

    @Test
    public void test2() throws ParseException {
        String birth="2020-09-08";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(birth);
        java.sql.Date birthDate=new java.sql.Date(parse.getTime());
        System.out.println(birthDate);
    }
}
