package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectDemo4 {
    public static void main(String[] args)  {
        try {
            //1.实例化
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个类名");
            String classname = scanner.nextLine();
            System.out.println("请输入一方法名");
            String methodName = scanner.nextLine();

            Class cls=Class.forName(classname);
            Object o = cls.newInstance();
            //2.调用方法
            //通过类对象获取要调用方法的方法对象
            Method method=cls.getMethod(methodName);
            //通过方法对象来调用该方法
            method.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
