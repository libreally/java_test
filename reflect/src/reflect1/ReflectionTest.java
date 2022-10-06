package reflect1;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class ReflectionTest {
    /**
     * 反射之前可以做的事情
     *
     */
    @Test
    public void test1(){
        //1.创建类对象
        Person p1=new Person("Tom",12);
        //2.调用属性方法
        p1.age=10;
        System.out.println(p1);
        p1.show();
       /* */
    }
    /**
     * 反射之后可以做的事情
     */
    @Test
    public void test2() throws Exception {
        //1.通过反射，创建person对象
        Class<Person> cla=Person.class;
        Constructor<Person> constructor = cla.getConstructor(String.class, int.class);
        Person obj = constructor.newInstance("Tom", 12);
        System.out.println(obj);
        //2.通过反射，调用指定对象的属性，方法
        Field age = cla.getDeclaredField("age");
        age.set(obj,10);//调用属性
        System.out.println(obj);
        //调用方法
        Method show = cla.getDeclaredMethod("show");
        show.invoke(obj);
        System.out.println(obj);
        System.out.println("*********************************************");
        //通过反射可以调用私有的属性和方法
        Constructor<Person> cons1 = cla.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person jerry = cons1.newInstance("jerry");
        System.out.println(jerry);
        //调用私有的属性和方法
        Field name = cla.getDeclaredField("name");
        name.setAccessible(true);
        name.set(jerry,"ha");
        System.out.println(jerry);
        Method showNation = cla.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        showNation.invoke(jerry, "中国");
        System.out.println(jerry);
    }
}

