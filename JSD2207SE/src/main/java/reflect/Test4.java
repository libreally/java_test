package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

import java.io.File;
import java.lang.reflect.Method;

/**
 * 自动调用与当前类Test4在同一个包中被注解@AutoRunClass标注的类中那些被@AutoRunMethod
 * 标注的方法。
 * 注:
 * 反射中的几个反射对象:Class,Method,Constructor,Field等都有isAnnotationPresent
 * 用来判断是否被某个注解标注了
 */
public class Test4 {
    public static void main(String[] args) throws Exception {
        File dir = new File(Test4.class.getResource(".").toURI());
        File[] subs = dir.listFiles(f->f.getName().endsWith(".class"));
        for(File sub : subs){
            String className = sub.getName().replace(".class","");
            Class cls = Class.forName(Test3.class.getPackage().getName()+"."+className);
            if(cls.isAnnotationPresent(AutoRunClass.class)){
                System.out.println("实例化:"+className);
                Object o = cls.newInstance();
                System.out.println(o);

                Method[] methods = cls.getDeclaredMethods();
                for(Method method : methods){
                    if(method.isAnnotationPresent(AutoRunMethod.class)){
                        System.out.println("开始调用方法:"+method.getName());
                        method.invoke(o);
                    }
                }

            }
        }
    }
}
