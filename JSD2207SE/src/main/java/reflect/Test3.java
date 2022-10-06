package reflect;

import reflect.annotations.AutoRunClass;

import java.io.File;

/**
 * 实例化与当前类Test3在同一个包中被@AutoRunClass标注的类
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        File dir = new File(Test3.class.getResource(".").toURI());
        File[] subs = dir.listFiles(f->f.getName().endsWith(".class"));
        for(File sub : subs){
            String className = sub.getName().replace(".class","");
            Class cls = Class.forName(Test3.class.getPackage().getName()+"."+className);
            if(cls.isAnnotationPresent(AutoRunClass.class)){
                System.out.println("实例化:"+className);
                Object o = cls.newInstance();
                System.out.println(o);
            }
        }
    }
}
