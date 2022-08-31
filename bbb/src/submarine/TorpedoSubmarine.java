package submarine;

import javax.swing.*;

/** 鱼雷潜艇 */
public class TorpedoSubmarine extends SeaObject implements EnemyScore {
    /**
     * 重写getScore()
     * @return 返回分数
     */
    public int getScore(){
        return 40;
    }
    /** 构造方法 ，super()子类去调用父类的构造方法 */
    public TorpedoSubmarine(){
        super(64,20);
    }

    /** 重写move()移动 */
    public void move(){
        x+=speed;
         //x+(向右)
    }
    /**重写getImage()*/
    @Override
    public ImageIcon getImage() {
        return Images.torpesubm;//返回战舰图片
    }
}
