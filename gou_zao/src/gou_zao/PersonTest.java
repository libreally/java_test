package gou_zao;
 /**
  * 构造器（构造方法constructor）的使用
  * 作用：创建对象,,,初始化对象属性
  * 如果没有显示的定义类的构造器的话，则系统默认提供一个空参数的构造器
  * 定义构造器的格式：权限修饰符 类名（形参列表）{}
  * 一个类中定义的多个构造器，彼此形成重载
  * 一旦显示定义了类的构造器，则系统不再提供默认构造器
  * 一个类中至少有一个构造器
  */
public class PersonTest {
    public static void main(String[] args) {
        //用构造器  创建类的对象：new +构造器
        Person p=new Person();
        p.eat();
        p.stady();
        Person p1=new Person("tom");
        System.out.println(p1.name);
    }
}
