/**
 * 类的成员： 成员变量、方法、构造器、初始化块、内部类（包括接口、枚举）
 * 代码块作用：用来初始化类，对象
 * 代码块如果修饰只能用static修饰 分为静态代码块和非静态代码块
 *静态代码块
 *   可以写输出语句
 *   随着类的加载而执行 只执行一次
 *
 *
 *非静态代码块
 *   可以写输出语句
 *   随着对象的创建而执行
 *   而且每创建一个对象就执行一次代码块
 *   作用：对对象的属性进行初始化
 *
 *含有构造器 代码块等结构时  运行顺序：先父类后子类 静态先行
 *
 * 对属性的赋值位置执行顺序
 *1.默认初始化
 * 2.显示初始化/代码块中赋值
 * 3.构造器中赋值
 * 4.有了对象以后，通过对象.属性 对象.方法进行赋值
 *
 */
public class BlockTest {
    public static void main(String[] args) {
        String desc = Person.desc;

        Person person=new Person();
        Person person1=new Person();

        System.out.println(person.age);
    }

}
class Person{
    String name;
    int age;
    static String desc="i'm person";//

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //静态代码块
    static {
        {
            System.out.println("hello static block");
        }
    }
    //非静态代码块
    {
        System.out.println("hello block");
        age=1;
    }
    public void eat(){
        System.out.println("eat");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public static void info(){
        System.out.println("i'm happy person");
    }
}
