package day02;

public class NstClassDemo {
    public static void main(String[] args) {
        /**
         * 创建了Aoo的一个派生类，但是没有名字
         * 为派生类创建了一个对象，名为aoo
         * new Aoo() {}是为派生类new一个对象
         *
         */
        Aoo aoo=new Aoo() {};
        /**
         * 又创建了Aoo的一个派生类，但是没有名字
         * 为派生类创建了一个对象，名为aoo1
         */
        Aoo aoo1=new Aoo() {};
        /**
         * 又创建了Aoo的一个派生类，但是没有名字
         * 为派生类创建了一个对象，名为boo
         * 大括号中的为派生类的类体
         */
        int num=55;
        Boo boo=new Boo() {
            @Override
            void show() {//重写Boo的方法
                System.out.println("shi");
                //num=55;匿名内部类中不能改变外部局部变量
            }
        };
        boo.show();//派生类对象boo调用派生类中的方法
    }
}
/**
 * 匿名内部类
 */
abstract class Boo{
    abstract void show();
}
abstract class Aoo{ }
