package submarine;

import javax.swing.*;
/** 战舰 */
public class Battleship extends SeaObject {
    private int life;   //命
    /** 构造方法 */
    public Battleship(){
        super(66,26,270,124,20);
        life = 5;
    }
    /** 重写move()移动 */
    public void move(){

    }
    //战舰左移
    public void moveLeft(){
        x -= speed;
    }
    //战舰右移
    public void moveRight(){
        x += speed;
    }
    /*//上移
    public void moveUp(){
        y -= speed;
    }
    //下移
    public void moveDown(){
        y += speed;
    }*/
    //战舰加命
    public void addLife(int num){
        life+=num;
    }
    public int getLife(){
        return life;
    }
    //战舰减命
    public void subtractLife(){
        life--;
    }

    /**重写getImage()*/
    public ImageIcon getImage() {
        return Images.battleship;//返回战舰图片
    }
    public Bomb ShootBomb(){
        return new Bomb(this.x,this.y);
    }
}
