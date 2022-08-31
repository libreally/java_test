package abstractTest;

/**
 * abstract关键字使用
 *    不能用来修饰属性、构造器等
 *    不能用来修饰私有方法、静态方法、final的方法/类
 *
 *
 *
 * 抽象类 抽象方法
 * 1.抽象类
 *    不可被实例化
 *    抽象类中有构造器，便于子类实例化调用
 *    开发中都会提供抽象类的子类，让子类对象实例化
 *
 * 2.抽象方法
 *     抽象方法只有方法声明没有方法体
 *     包含抽象方法的类一定是抽象类
 *     若子类重写了父类的所有抽象方法后，才可以实例化
 *     若子类没有重写父类的所有抽象方法，则子类是一个抽象类
 *
 *
 */
public class AbstractTest {
    public static void main(String[] args) {
        //一旦Person类成为抽象类不可被实例化（不可new）
       /* Person person=new Person();
        person.eat();*/
    }

}
abstract class Person{
    String name;
    int age;
    public Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //抽象方法
    public abstract void bbb();
    public void eat(){
        System.out.println("eat");
    }
    public void walk(){
        System.out.println("walk");
    }
}

class Student extends Person{
    @Override
    public void bbb() {
        System.out.println("bbb");
    }
}
//抽象类为什么不可以使用final关键字声明
//因为final明确了不能被继承，而抽象类一定要被继承才可以new对象