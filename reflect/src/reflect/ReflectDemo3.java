package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用指定构造器实例化对象
 *
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Person p=new Person("liu",33);
        System.out.println("p = " + p);

        Class<?> cls= Class.forName("reflect.Person");

        Constructor<?> constructor = cls.getConstructor(String.class, int.class);
        Object o = constructor.newInstance("li",23);
        System.out.println("o = " + o);
    }
}
