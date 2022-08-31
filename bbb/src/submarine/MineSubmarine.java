package submarine;

import javax.swing.*;

/** 水雷潜艇 */
public class MineSubmarine extends SeaObject implements EnemyLife{
    /**重写getLife()得命
     * @return 返回命数
     */
    public int getLife(){
        return 1;
    }
    /** 构造方法 */
    public MineSubmarine(){
        super(63,19);
    }
    /** 重写move()移动 */
    public void move(){ x+=speed;
        //x+(向右)
    }
    /**重写getImage()*/
    @Override
    public ImageIcon getImage() {
        return Images.minesubm;//返回战舰图片
    }

    /**水雷发射*/
    public Mine shootMine(){
        return new Mine(this.x+this.width,this.y-11);//this指水雷挺的位置
    }
}
