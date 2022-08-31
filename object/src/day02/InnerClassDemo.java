package day02;

public class InnerClassDemo {
    public static void main(String[] args) {
        Ma ma=new Ma();
        System.out.println(ma);

    }

}
/**
 * 成员内部类  对外不具备可见性
 * 内部内类可访问外部类 引用方法  外部类名.this
 * 内部类分类：成员内部类（静态、非静态） 局部内部类（方法内、代码块内、构造器内）
 *
 * 成员内部类：作为外部类的成员
 *      调用外部类的结构
 *      可以被static修饰
 *      可以被权限修饰符修饰
 *
 *
 * 作为类
 *      可以被final修饰，表示不能被继承，反之可以被继承
 *      可以被abstract修饰，不能被实例化
 *
 *
 */
class Ma{
    private int b=2;
    void show(){
        Baby baby=new Baby();
        System.out.println(b);
        System.out.println(Ma.this.b);

    }
    //成员内部类
    class Baby{
    }
    public void test(){
        //局部内部类
        class BB{

        }
    }
}




