package submarine;

import javax.swing.*;

/** 炸弹 */
public class Bomb extends SeaObject {
    /** 构造方法 */
    public Bomb(int x,int y){ //因为炸弹的初始坐标，是根据战舰的坐标计算出来的，所以不能写死
        super(9,12,x,y,3);
    }

    /** 重写move()移动 */
    public void move(){
        y+=speed;
         //y+(向下)
    }
    /*public void moveD(){
        y-=speed;//炸弹上
    }*/
    /**重写getImage()*/
    @Override
    public ImageIcon getImage() {
        return Images.bomb;//返回战舰图片
    }
    /**
     * 判断炸弹是否越界
     * @return 越界返回true否则返回false
     */
    public boolean isOutOfBounds(){
        return y>=World.HEIGHT;
    };
}
