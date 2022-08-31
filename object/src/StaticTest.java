/**
 *static的练习
 */
public class StaticTest {
    public static void main(String[] args) {
        Circle c1=new Circle();
        Circle c2=new Circle();

        System.out.println("c1的id:"+c1.getId());
        System.out.println("c1的id:"+c2.getId());
        System.out.println("c1的id:"+Circle.getTotal());//静态方法通过 类名.方法调用

    }

}
class Circle{
    private double radius;
    private int id;
    //静态变量 随着类的加载载入内存 静态方法中不能调用非静态方法
    private static int total;//创建的个数
    private static int init=1001;//多个对象共享

    public Circle(){
        id=init++;
        total++;
    }
    public Circle(double radius){
        this();
//        id=init++;
//        total++;
        this.radius=radius;
    }

    public double findArea(){
        return radius*radius*Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    public static int getTotal() {
        return total;
    }

}