package submarine;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/** 海洋对象 */
public abstract class SeaObject {
    /**状态*/
    public static final int LIVE = 0;//活
    public static final int DEAD = 1;//死
    protected int state = LIVE;//当前状态 默认活

    protected int width;  //宽     //实际项目中成员变量都应该是private的，
    protected int height; //高     //因此此时咱们还没有讲到getter/setter，
    protected int x;      //x坐标  //所以暂时先设计为protected的
    protected int y;     //y坐标
    protected int speed;  //速度
    /** 专门给侦察潜艇、鱼雷潜艇、水雷潜艇提供的 */
    //因为三种潜艇的width/height都是不一样的，所以数据不能写死，需传参写活
    //因为三种潜艇的x/y/speed代码都是一样的，所以数据可以写死，不需要传参

    //构造方法
    public SeaObject(int width,int height){
        this.width = width;
        this.height = height;
        x = -width;
        Random rand = new Random(); //创建随机数对象
        y = rand.nextInt(479-height-150+1)+150; //150到(窗口高-潜艇高)之内随机生成
        speed = rand.nextInt(3)+1; //1到3之内随机生成
    }

    /** 专门给战舰、水雷、炸弹提供的 */
    //因为三种对象的width/height/x/y/speed都是不一样的，所以数据不能写死，需传参写活
    public SeaObject(int width,int height,int x,int y,int speed){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    /** 移动 */
    public abstract void move();//只有定义，没有具体方法
    /**获取图片*/
    public abstract ImageIcon getImage();

    /**判断状态活*/
    public boolean isLive() {
        return state==LIVE;
    }
    /**判断状态死*/
    public boolean isDead(){return state==DEAD;}
    /**画对象*/
    public void paintImage(Graphics g){
        if(this.isLive()){
            this.getImage().paintIcon(null,g,this.x,this.y);
        }
    }

    /**
     * 检测潜艇是否越界
     * @return 越界返回true否则返回false
     */
    public  boolean isOutOfBounds(){
        return x>=World.WIDTH;
    }

    /**
     * 检测碰撞 this表示潜艇，other炸弹
     * @param other
     * @return 撞上返回true否则false
     */
    public boolean isHit(SeaObject other){
        int x1=this.x-other.width;//潜艇的x-炸弹的宽
        int x2=this.x+this.width;//潜艇的x+潜艇的宽
        int y1=this.y-other.height;//潜艇的y-炸弹的高
        int y2=this.y+this.height;//潜艇的y+潜艇的高
        int x=other.x;//炸弹的x
        int y=other.y;//炸弹的y
        //x在x1  x2之间并且 y在y1 y2之间表示撞上
        return x>=x1 && x<=x2 && y>=y1 && y<=y2;
    }
    public void goDead(){
        state=DEAD;//去死
    }

}