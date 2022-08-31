/**
 * 1.创建类、设计类成员
 * 2.创建类对象===类的实例化
 * 3.通过调用使用对象
 * 如果创建了一个类的多个对象，则每一个对象都有独立的属性
 * 通过 对象.属性 或 对象方法 调用对象的结构
 */
//类包含属性和方法
class  Person{
    //属性==成员变量
    String name;
    int age=1;
    boolean isMale;
    //方法==函数
    public void eat(){

        System.out.println("吃饭");
    }
    public void sleep(){

        System.out.println("睡觉");
    }
    public void talk(String Language){
        System.out.println("说话"+Language);
    }
}
public class personTest {
    public static void main(String[] agrs){
        //类的实例化  创建（new对象）类对象
        Person p1=new Person();
        //Scanner scanner=new Scanner(System,in)
        //调用属性 “对象.属性”  赋值和调用
        p1.name="Tom";
        p1.isMale=true;
        System.out.println(p1.name);
        //调用方法  “对象.方法”
        p1.eat();
        p1.sleep();
        p1.talk("Chinese");

        Person p2=new Person();
        System.out.println(p2.name);//null
        System.out.println(p2.isMale);//false 一维数组的默认属性为false
        /**
         * 每new一次就在堆中创建一个对象实体
         * 如果创建了一个类的多个对象，则每个对象都独立的拥有一套类的属性（非static的）
         * 也就是说如果改变一个对象的属性，不会改变另一个属性的值
         */
    }
}

