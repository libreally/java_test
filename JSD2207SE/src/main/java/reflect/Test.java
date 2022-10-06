package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 利用反射机制调用Person类中所有无参方法
 * 1:加载Person的类对象
 * 2:实例化Person
 * 3:通过类对象获取所有无参方法
 *   提示:Method上定义了:int getParameterCount()
 *   该方法的作用是获取当前Method表示的方法中有多少个参数
 * 4:执行invoke来调用这个方法
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();
        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods){
            //判断是否为无参数方法
            if(method.getParameterCount()==0 &&
               method.getModifiers()== Modifier.PUBLIC &&//是否为公开方法
               method.getName().contains("e")//名字是否含有字符"e"
            ){
                System.out.println("调用方法:"+method.getName()+"()");
                method.invoke(obj);
            }
        }
    }
}
