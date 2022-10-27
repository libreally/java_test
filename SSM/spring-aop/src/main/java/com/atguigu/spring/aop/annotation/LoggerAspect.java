package com.atguigu.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


import org.aspectj.lang.annotation.Aspect;

/**
 * aop流程：将非核心代码抽出（横切关注点）封装到一个类中（切面） 每一个横切关注点都是一个通知方法
 * 然后通过切入点放置到连接点
 *
 *   Aspect 创建切面
 */
@Aspect
@Component
public class LoggerAspect {
//    前置通知 加入切面路径
//    目标方法执行之前执行此方法
    @Before("execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int ,int ))")
    public void beforeAdviceMethod(){
        System.out.println("LoggerAspect：前置通知");
    }
}
