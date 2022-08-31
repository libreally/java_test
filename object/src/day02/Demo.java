package day02;

/**
 * 属性不体现多态性
 */
public class Demo {
    public static void main(String[] args) {
        a s=new b();//向上造型
        s.m();//运行看右边
        System.out.println(s.a);//编译看左边
        //向下转型 为了使父类调用子类中特有的方法
        b n=(b)s;
        n.ss();

    }
}
class a{
    int a=1;
    public void m(){
        System.out.println("a");
    }
}
class b extends a{
    int a=2;
    public void m(){
        System.out.println("b");
    }
    public void ss(){
        System.out.println("ss");
    }
}

