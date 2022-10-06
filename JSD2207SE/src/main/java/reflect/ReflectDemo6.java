package reflect;

import java.lang.reflect.Method;

public class ReflectDemo6 {
    public static void main(String[] args) throws Exception {
//        Person p = new Person();
//        p.hehe();
        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();
        /*
            getMethod()和getMethods()可以获取本类所有的公开方法
            getDeclaredMethod()和getDeclaredMethods()可以获取被类定义的方法(包含私有方法，不含有超类继承的)
         */
//        Method method = cls.getMethod("hehe");
        Method method = cls.getDeclaredMethod("hehe");
        method.setAccessible(true);//强行打开访问权限
        method.invoke(obj);
        method.setAccessible(false);//用后应当及时关闭访问权限


    }
}
