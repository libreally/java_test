package reflect1;

import org.junit.jupiter.api.Test;

/**
 * 获取Class的四种方式
 * 前三种掌握
 * 第三种重要
 */
public class TestReflection {
    @Test
    public void test1() throws Exception {
        //方式一:抵用运行时类的属性 .class
        Class<Person> cls=Person.class;
        System.out.println(cls);

        //方式二：通过运行时类的对象
        Person p1=new Person();
        Class<? extends Person> cls1 = p1.getClass();
        System.out.println(cls1);

        //方式三：通过Class的静态方法formName（String classPath）
        Class<?> cls2 = Class.forName("reflect1.Person");
        System.out.println(cls2);


        //方式四：类的加载器ClassLoader
        ClassLoader classLoader = TestReflection.class.getClassLoader();
        Class<?> cls3 = classLoader.loadClass("reflect1.Person");
        System.out.println(cls3);
    }
}
