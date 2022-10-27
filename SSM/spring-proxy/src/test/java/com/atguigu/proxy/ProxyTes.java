package com.atguigu.proxy;

import com.atguigu.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTes {
    @Test
    public void test() {
        /*CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1,2);*/
        ProxyFactory proxyFactory=new ProxyFactory(new CalculatorImpl());
        proxyFactory.getProxy();
    }
}
