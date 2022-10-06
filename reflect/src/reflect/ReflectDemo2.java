package reflect;

import java.util.Scanner;

public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Person p = new Person();

        System.out.println("p = " + p);
        //1.加载需要实例化对象的类的类对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个类名");
        String className = scanner.nextLine();
        Class cls = Class.forName(className);
        //Class cls = Class.forName("reflect.Person");
        //2.类对象提供了方法 newInstance利用其表示的类的公开的无参构造器实例化
        Object o = cls.newInstance();
        System.out.println("o = " + o);
    }
}
