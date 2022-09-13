package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo6 {
    public static void main(String[] args)  {
        try {
            Class<?> cls= Class.forName("reflect.Person");
            Object o = cls.newInstance();
             /*
            getMethod()和getMethods()可以获取本类所有的公开方法
            getDeclaredMethod()和getDeclaredMethods()可以获取被类定义的方法(包含私有方法，不含有超类继承的)
         */
            Method method= cls.getDeclaredMethod("hehe");
            method.setAccessible(true);//强行打开访问权限
            method.invoke(o);
            method.setAccessible(false);//用后应当及时关闭访问权限
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
