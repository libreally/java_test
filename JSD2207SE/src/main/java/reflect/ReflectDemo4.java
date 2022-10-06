package reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 使用反射机制调用方法
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.dance();

        //1实例化
       /* Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();//Person obj = new Person();
        //2调用方法
        //2.1通过类对象获取要调用方法的方法对象(Method对象)
        Method method = cls.getMethod("dance");//dance方法
        //2.2通过方法对象来调用该方法
        method.invoke(obj);//p.dance();*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要实例化的类的类名:");
        String className = scanner.nextLine();
        System.out.println("请输入方法名:");
        String methodName = scanner.nextLine();

        Class cls = Class.forName(className);
        Object obj = cls.newInstance();//Person obj = new Person();
        //2调用方法
        //2.1通过类对象获取要调用方法的方法对象(Method对象)
        Method method = cls.getMethod(methodName);//dance方法
        //2.2通过方法对象来调用该方法
        method.invoke(obj);//p.dance();


    }
}





