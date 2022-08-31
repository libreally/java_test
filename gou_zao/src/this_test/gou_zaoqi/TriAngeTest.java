package this_test.gou_zaoqi;

public class TriAngeTest {
    public static void main(String[] args) {
        TriAngle t1=new TriAngle();
        t1.setBase(2.0);//初始化
        t1.setHeight(2.4);
        /*
        *t1.base=2.3;
        * t1.height=3.2;
        * 此时不可用 is not visible 他们是私有属性不可调用，只可以通过方法调用
         */
        System.out.println(t1.getBase()+"\t"+t1.getHeight());
        TriAngle t2=new TriAngle(5.1,5.6);//赋值
        System.out.println(t2.getBase()+"\t"+ t2.getHeight());
        System.out.println("三角形面积："+t2.area());
    }
}
