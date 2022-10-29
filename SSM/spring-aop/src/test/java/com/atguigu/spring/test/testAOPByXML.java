package com.atguigu.spring.test;

import com.atguigu.spring.aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAOPByXML {
    @Test
    public void testAOPByXML(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-xml.xml");
        Calculator ca = ioc.getBean(Calculator.class);
        ca.add(8,6);
    }
}
