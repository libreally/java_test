package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

import java.io.File;
import java.lang.reflect.Method;

/**
 *  自动调用与当前类Test4在同一个包中被注解@AutoRunClass标注的类中那些被@AutoRunMethod
 *  标注的方法指定次(次数有注解@AutoRunMethod的参数指定)。
 */
public class Test5 {
    public static void main(String[] args) throws Exception {
        File dir = new File(Test5.class.getResource(".").toURI());
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
                        AutoRunMethod arm = method.getAnnotation(AutoRunMethod.class);
                        int value = arm.value();
                        System.out.println("开始调用方法:"+method.getName()+"()"+value+"次");
                        for(int i=0;i<value;i++) {
                            method.invoke(o);
                        }
                    }
                }

            }
        }
    }
}
