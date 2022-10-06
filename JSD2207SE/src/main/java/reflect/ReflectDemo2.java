package reflect;

import java.util.Scanner;

/**
 * 使用反射机制实例化对象
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        System.out.println(p);

        //1加载需要实例化对象的类的类对象
//        Class cls = Class.forName("reflect.Person");
        /*
            日期类，该类的每一个实例用于表示一个具体的时间点，默认创建表示当前系统时间
            java.util.Date
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个类名");
        String className = scanner.nextLine();
        Class cls = Class.forName(className);

        //2类对象提供了方法:newInstance()可以利用其表示的类的公开的无参构造器实例化
        Object obj = cls.newInstance();
        System.out.println(obj);
    }
}





