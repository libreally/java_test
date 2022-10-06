package reflect;

import reflect.annotations.AutoRunMethod;

import java.lang.reflect.Method;

/**
 * 获取注解参数
 */
public class ReflectDemo8 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        Method method = cls.getDeclaredMethod("sayHello");
        if(method.isAnnotationPresent(AutoRunMethod.class)){
            //获取该方法对象所表示的方法上的特定注解
            AutoRunMethod arm = method.getAnnotation(AutoRunMethod.class);
            //通过注解对象获取参数value的值
            int value = arm.value();
            System.out.println("参数:"+value);

        }

    }
}




