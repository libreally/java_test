package submarine;

import javax.swing.*;

/** 侦察潜艇 */
public class ObserveSubmarine extends SeaObject implements EnemyScore{
    /**
     * 重写getScore()
     * @return 返回分数
     */
    public int getScore(){
        return 10;
    }

    /** 构造方法 */
    public ObserveSubmarine(){
        super(63,19);
    }

    /** 重写move()移动 */
    public void move(){
        x+=speed;
         //x+(向右)
    }
    /**重写getImage()*/
    @Override
    public ImageIcon getImage() {
        return Images.obsersubm;//返回战舰图片
    }
}