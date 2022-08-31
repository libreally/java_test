package Singleton;

/**
 * 单例设计模式
 *所谓单例设计模式，就是采用一定的方法保证在整个软件系统中，对某个类只能存在一个对象实例
 *
 *
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Bank bank=Bank.getInstance();
        Bank bank1=Bank.getInstance();

        System.out.println(bank==bank1);//两个是同一个对象
    }
}

/**
 * 饿汉式单例设计模式
 */
class Bank{
    //1.私有化类的构造器
    private Bank(){

    }
    //2.内部创建类的对象
    //4.要求此对象也是静态的
    private static Bank instance = new Bank();
    //3.提供公共静态方法返回类对象
    public static Bank getInstance(){
        return instance;
    }
}
