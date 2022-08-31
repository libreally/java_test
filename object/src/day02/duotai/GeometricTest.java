package day02.duotai;

public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest test=new GeometricTest();
        Circle c1=new Circle("blank",1.0,1.0);
        test.displayGeometricObject(c1);
        MyRectangle r1=new MyRectangle("balnk",1.0,2,4);
        boolean idEqual=test.equalsArea(c1,r1);
        System.out.println("面积是否相等："+idEqual);
    }
    public boolean equalsArea(GeometricObject geometricObject1,GeometricObject geometricObject2){
        return geometricObject1.findArea()==geometricObject2.findArea();
    }
    public void displayGeometricObject(GeometricObject geometricObject){
        System.out.println("面积："+ geometricObject.findArea());
    }
}
