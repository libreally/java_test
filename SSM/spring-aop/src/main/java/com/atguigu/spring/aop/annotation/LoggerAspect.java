package com.atguigu.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

/**
 * aop流程：将非核心代码抽出（横切关注点）封装到一个类中（切面） 每一个横切关注点都是一个通知方法
 * 然后通过切入点放置到连接点
 *
 *   Aspect 创建切面
 *
 */
@Aspect
@Component
public class LoggerAspect {
    /*公共切入点表达式*/
    @Pointcut("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}
//    前置通知 加入切面路径
//    目标方法执行之前执行此方法
//    @Before("execution(public int com.atguigu.spring.aop.annotation.CalculatorImpl.add(int ,int ))")
//    @Before("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的方法名
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的方法名
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect, 前置通知方法:"+signature.getName()+",参数:"+ Arrays.toString(args));
    }
    // 后置通知 在目标对象方法的finally字句中执行
    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的方法名
        Signature signature = joinPoint.getSignature();

        System.out.println("LoggerAspect, 后置通知方法:"+signature.getName()+",执行完成");
    }
    //返回值之后执行
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect, 返回通知方法:"+signature.getName()+",结果:"+result);
    }
    //异常通知(例外通知) 在catch中通知
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect, 异常通知方法:"+signature.getName()+",异常:"+ex);
    }
    @Around(value = "pointCut()")
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
