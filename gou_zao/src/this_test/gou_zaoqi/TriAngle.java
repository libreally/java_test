package this_test.gou_zaoqi;
//计算三角形面积
public class TriAngle {
    private double base;//底边长
    private double height;//高
    public TriAngle(){

    }
    public TriAngle(double b,double h){
        base=b;
        height=h;
    }
    public void setBase(double b){
        base=b;
    }
    public double getBase(){
        return base;
    }
    public void setHeight(double h){
        height=h;
    }
    public double getHeight(){
        return height;
    }
    public double area(){
        double area;
        return area=(getBase()*getHeight())/2;
    }
}
