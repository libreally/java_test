package Singleton;
/**
 * 懒汉式单例设计模式  啥时候用啥时候造对象
 */

public class SingletonTest2 {
    public static void main(String[] args) {
        Order order=Order.getInstance();
        Order order1=Order.getInstance();

        System.out.println(order==order1);
    }

}
class Order{
    //1.私有化类的构造器
    private Order(){}
    //2.声明当前类的对象，不初始化
    //4.此对象也必须声明为static
    private static Order instance=null;

    //3.声明public。static的返回当前类对象方法
    public static Order getInstance(){
        if (instance==null){
            instance=new Order();
        }
        return instance;

    }

}
