package reflect;

import java.lang.reflect.Constructor;

/**
 * 使用指定构造器实例化对象
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        //Person(String,int)
        Person p = new Person("刘桑",55);
        System.out.println(p);

        Class cls = Class.forName("reflect.Person");
        //通过类对象获取其表示的类的某个指定的构造器
//        cls.getConstructor();//Person()
        /*
            Constructor类的每一实例用于表示某个类上的某一个构造器
         */
        Constructor c = cls.getConstructor(String.class,int.class);//Person(String,int)
        Object o = c.newInstance("苍桑",55);//new Person("苍桑",55);
        System.out.println(o);

    }
}





