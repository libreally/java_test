package reflect;

import java.lang.reflect.InvocationTargetException;
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
    public static void main(String[] args) {
        try {
            Class cls=Class.forName("reflect.Person");
            Object o = cls.newInstance();
            Method[] method = cls.getDeclaredMethods();
            for (Method method1:method){
                if ( method1.getParameterCount()==0 &&
                        method1.getModifiers()== Modifier.PUBLIC
                &&method1.getName().contains("e")){
                    System.out.println(method1.getName());
                    method1.invoke(o);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
