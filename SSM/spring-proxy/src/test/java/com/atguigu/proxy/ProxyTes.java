package com.atguigu.proxy;

import com.atguigu.spring.proxy.CalculatorImpl;
import com.atguigu.spring.proxy.CalculatorStaticProxy;
import org.junit.Test;

public class ProxyTes {
    @Test
    public void test() {
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1,2);
    }
}
