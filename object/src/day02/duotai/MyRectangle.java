package day02.duotai;

public class MyRectangle extends GeometricObject{
    private double height;
    private double width;

    public MyRectangle(String color, double weight, double height, double width) {
        super(color, weight);
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }


    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double findArea() {
        return height*width;
    }
}
