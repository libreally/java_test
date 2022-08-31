package zhi_chaun_di;

public class PassObject {
    int time;
    public void printAreas(Circle c,int time){
        System.out.println("Radius\t\tArea");
        //设置圆半径
        for (int i=1;i<=time;i++){
            c.radius=i;
            //double area=c.findArea();
            System.out.println(c.radius+"\t\t\t"+c.findArea());
        }
     c.radius=time+1;
    }
}
