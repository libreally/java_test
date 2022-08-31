package Interface;
//接口和类是并列结构

/**
 * 接口能定义全局常量和抽象方法，静态方法和默认方法
 * 接口中不可以定义构造器不可以实例化
 * 通过类实现接口implements
 *如果实现类覆盖了接口中的所有抽象方法，则此类可以实例化
 * 如果没有重写所有接口中的方法，则是定义为抽象方法
 * 单继承 多实现
 * 接口与接口之间可以（多）继承
 *
 * 接口中定义的静态方法，只能通过接口来调用
 * 通过实现类的对象，可以调用接口中的默认方法
 * 如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
 *
 */
public class InterfaceTest  implements Flyable{
    public static void main(String[] args) {

        System.out.println(Flyable.MAX_SPEED);

        InterfaceTest interfaceTest=new InterfaceTest();
        interfaceTest.fly();

    }

    @Override
    public void fly() {
        System.out.println("起飞");
    }

    @Override
    public void stop() {
        System.out.println("降落");
    }
}
interface Flyable{
    //全局常量
    public static final int MAX_SPEED=7900;
    public static final int MIN_SPEED=1;

    public abstract void fly();
    //省略了public abstract
    void stop();

}
abstract class Plan implements Flyable{

    @Override
    public void fly() {

    }
}
interface AA{
    void method1();
}
interface BB{
    void method2();
}
interface CC extends AA,BB{
    //其中包含了两个方法method1()  method2()
}

interface DD{
    //接口中定义的静态方法，只能通过接口来调用(自己使用)
    public static void method(){
        System.out.println("sdd");
    }
    default void method1(){
        System.out.println("fjj");
    }

}