package com.atguigu.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * jdk方式动态代理
 */
public class ProxyFactory {
    private Object terget;

    public ProxyFactory(Object terget) {
        this.terget = terget;
    }
    public Object getProxy(){
        /*ClassLoader loader, 类加载器,指定加载动态生成的代理的类加载器
         Class<?>[] interfaces, 获取目标对象实现的所有的接口的对象的数组
         InvocationHandler h,设置代理类的抽象方法的重写
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?>[] interfaces = terget.getClass().getInterfaces();
        InvocationHandler H = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*
                * proxy 代理对象
                * method 执行的方法
                * args 要执行的方法的参数列表
                * 调用目标对象的实现过程
                * */
                System.out.println("日志 方法:"+method.getName()+",参数:"+ Arrays.toString(args));
                Object result = method.invoke(terget, args);
                System.out.println("日志 方法:"+method.getName()+",参数:"+ result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,H);
    }
}
