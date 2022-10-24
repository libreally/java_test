package com.atguigu.spring.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class helloWorldTest {
    @Test
    public void test(){
//        获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//获取IOC容器bean对象
        helloWorld helloWorld = (com.atguigu.spring.pojo.helloWorld) ioc.getBean("helloWorld");
        helloWorld.sayHello();
    }
}
