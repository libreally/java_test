package com.atguigu.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * aop流程：将非核心代码抽出（横切关注点）封装到一个类中（切面） 每一个横切关注点都是一个通知方法
 * 然后通过切入点放置到连接点
 *
 *  基于xml的 Aspect 创建切面
 *
 */
@Component
public class LoggerAspect {

    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的方法名
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的方法名
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect, 前置通知方法:"+signature.getName()+",参数:"+ Arrays.toString(args));
    }

    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的方法名
        Signature signature = joinPoint.getSignature();

        System.out.println("LoggerAspect, 后置通知方法:"+signature.getName()+",执行完成");
    }

    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect, 返回通知方法:"+signature.getName()+",结果:"+result);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect, 异常通知方法:"+signature.getName()+",异常:"+ex);
    }


    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result=null;
        //表示目标对象方法的执行
        try {
            System.out.println("环绕通知-->前置通知");
            result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->异常通知");
        }finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }
}
