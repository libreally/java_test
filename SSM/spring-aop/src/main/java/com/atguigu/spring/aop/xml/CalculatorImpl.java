package com.atguigu.spring.aop.xml;

import org.springframework.stereotype.Component;

/*就是说当我们的类不属于各种归类的时候
（不属于@Controller、@Services等的时候），
我们就可以使用@Component来标注这个类。*/
@Component
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部：result" + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("方法内部：result" + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("方法内部：result" + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("方法内部：result" + result);
        return result;
    }
}
