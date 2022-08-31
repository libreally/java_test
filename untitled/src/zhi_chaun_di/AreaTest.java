package zhi_chaun_di;

public class AreaTest {
    public static void main(String[] args) {
        PassObject test=new PassObject();
        Circle c=new Circle();
        test.printAreas(c,5);
        System.out.println("now radius is:"+c.radius);
    }
}
