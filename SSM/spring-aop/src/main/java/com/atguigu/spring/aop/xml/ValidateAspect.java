package com.atguigu.spring.aop.xml;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 基于注解实现的aop
 * 切面优先级设置 Order 值越小优先级越大
 */


@Component
public class ValidateAspect {

    public void beforeMethod(){
        System.out.println("ValidateAspect: 前置通知");
    }
}
