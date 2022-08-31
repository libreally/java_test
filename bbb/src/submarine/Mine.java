package submarine;

import javax.swing.*;

/**
 *  水雷
 */
public class Mine extends SeaObject {
    /** 构造方法 */           //Mine m = new Mine(100,200);
    public Mine(int x,int y){ //因为水雷的初始坐标，是根据水雷潜艇的坐标计算出来的，所以不能写死
        super(11,11,x,y,1);
    }

    /** 重写move()移动 */
    public void move(){y-=speed;
         //y-(向上)
    }
    /**重写getImage()*/
    @Override
    public ImageIcon getImage() {
        return Images.mine;//返回战舰图片
    }
    /**
     * 判断水雷是否越界
     * @return 越界返回true否则返回false
     */
    public boolean isOutOfBounds(){
        return y<=150-height;
    };
}
