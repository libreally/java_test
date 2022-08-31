package submarine;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.awt.event.*;

/** 整个游戏窗口  */
public class World extends JPanel{
    public static final int WIDTH = 641;//窗口宽
    public static final int HEIGHT = 479;//窗口高

    public static final int RUNNING=0;
    public static final int PAUSE=1;
    public static final int GAME_OVER=2;
    private int state = RUNNING;


    private final Battleship ship = new Battleship();//战舰对象
    private SeaObject[] submarines = {};//潜艇数组
    private Bomb[] bombs = {};//炸弹数组（下）

    /*private Bomb[] bombs1={}; //炸弹数组上*/
    private Mine[] mines = {};//水雷数组
    /**
     * 生成所有潜艇对象
     * 使用random控制概率
     */
    private SeaObject nextSubmarine(){

        Random rand = new Random();
        int type=rand.nextInt(20);
        if(type<10){  //返回侦察潜艇
            return new ObserveSubmarine();
        } else if (type<16){//返回鱼类潜艇
            return new TorpedoSubmarine();
        }else {//返回水雷潜艇
            return new MineSubmarine();
        }
    }
    /**控制频率（潜艇入场计数）*/
    private int subEnterIndex=0;
    private void submarineEnterAction() {//每10毫秒走一次
        subEnterIndex++;
        if(subEnterIndex%40==0){//每400毫秒加一次
            SeaObject object=nextSubmarine();//接收返回的类型潜艇
            submarines= Arrays.copyOf(submarines,submarines.length+1);//扩容，因为潜艇数组是空
            submarines[submarines.length-1]=object;//将object添加到最后一个元素上
        }
    }


    /**水雷动*/
    private int mineEnterIndex=0;
    private void mineEnterAction() {//每10毫秒走一次
        mineEnterIndex++;
        if(mineEnterIndex%100==0){
            for (SeaObject submarine : submarines) {
                if (submarine instanceof MineSubmarine) {//判断是否时水雷潜艇，如果不是则无法转换
                    MineSubmarine ms = (MineSubmarine) submarine;//强制转化
                    Mine obj = ms.shootMine();//获取水雷对象
                    mines = Arrays.copyOf(mines, mines.length + 1);//扩容
                    mines[mines.length - 1] = obj;
                }
            }
        }
    }
    /**海洋对象动*/
    private void moveAction() {
        for (SeaObject seaObject : submarines) {
            seaObject.move();//潜艇动
        }
        /*for (int i=0;i<submarines.length;i++){
            submarines[i].move();
        }*/
        for (Mine mine : mines) {
            mine.move();//水雷动
        }
        for (Bomb bomb : bombs) {
            bomb.move();//炸弹动
        }
        /*
        for (Bomb bomb : bombs1) {
            bomb.moveD();//炸弹上
        }
        */
    }
    /**删除越界对象*/
    private void outOfBoundsAction() {
        for (int i=0;i<submarines.length;i++){
            if(submarines[i].isOutOfBounds()||submarines[i].isDead()){//越界或者死了的都删除
                submarines[i]=submarines[submarines.length-1];
                submarines=Arrays.copyOf(submarines,submarines.length-1);
            }
        }
        for (int i=0;i<mines.length;i++){
            if(mines[i].isOutOfBounds()||mines[i].isDead()){//越界或者死了的都删除
                mines[i]=mines[mines.length-1];
                mines=Arrays.copyOf(mines,mines.length-1);
            }
        }
        for (int i=0;i<bombs.length;i++){
            if(bombs[i].isOutOfBounds()||bombs[i].isDead()){//越界或者死了的都删除
                bombs[i]=bombs[bombs.length-1];
                bombs=Arrays.copyOf(bombs,bombs.length-1);
            }
        }
        /*for (int i=0;i<bombs1.length;i++){
            if(bombs1[i].isOutOfBounds()||bombs1[i].isDead()){
                bombs1[i]=bombs1[bombs1.length-1];
                bombs1=Arrays.copyOf(bombs1,bombs1.length-1);
            }
        }*/
    }

    /**
     * 炸弹与潜艇碰撞
     */
    private int score=0;
    private void bombBangAction() {
        //获取每一个炸弹
        for (Bomb b : bombs) {
            //获取每一个潜艇
            for (SeaObject s : submarines) {
                if (s.isLive() && b.isLive() && s.isHit(b)) {//都活着并且撞到
                    s.goDead();
                    b.goDead();
                    if (s instanceof EnemyScore) {
                        EnemyScore es = (EnemyScore) s;
                        score += es.getScore();
                    }
                    if (s instanceof EnemyLife) {
                        EnemyLife ea = (EnemyLife) s;
                        int num = ea.getLife();
                        ship.addLife(num);
                    }
                }
            }
        }

    }

    //水雷碰撞战舰,战舰减一条命
    private void mineBangAction() {
        for (Mine m : mines) {
            if (m.isLive() && ship.isLive() && m.isHit(ship)) {
                m.goDead();
                ship.subtractLife();
            }
        }
    }
    /**
     * 检测游戏结束
     */
    public void checkGameOverAction(){
        if(ship.getLife()<=0){
            state=GAME_OVER;
        }
    }
    /**启动各动作*/
    private void action(){
        /*监听器*/
        KeyAdapter k = new KeyAdapter() {
            /**按空格键炸弹发出*/
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_P){//按下p键暂停
                    if(state==RUNNING){
                        state=PAUSE;
                    }else if (state==PAUSE){
                        state=RUNNING;
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    Bomb obj = ship.ShootBomb();
                    bombs=Arrays.copyOf(bombs,bombs.length+1);
                    bombs[bombs.length-1]=obj;
                }
                /*if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    Bomb obj1 = ship.ShootBomb();
                    bombs1=Arrays.copyOf(bombs1,bombs1.length+1);
                    bombs1[bombs1.length-1]=obj1;
                }*/
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    ship.moveLeft();//战舰左移
                }
                if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                    ship.moveRight();//战舰右移
                }
                /*if (e.getKeyCode()==KeyEvent.VK_UP){
                    ship.moveUp();//战舰上移
                }
                if (e.getKeyCode()==KeyEvent.VK_DOWN){
                    ship.moveDown();//战舰下移
                }*/
            }
        };
        this.addKeyListener(k);

        Timer timer=new Timer();//定时器对象
        int interval = 10;//定时间隔
        timer.schedule(new TimerTask() {
            @Override
            public void run() {//定时干的事，每10毫秒自动执行
                    submarineEnterAction();//潜艇入场
                    mineEnterAction();//水雷入场
                    moveAction();//海洋移动
                    outOfBoundsAction();//删除越界对象
                    bombBangAction();//炸弹与潜艇碰撞
                    mineBangAction();//水雷与战舰碰撞
                    checkGameOverAction();//检测游戏结束
                    System.out.println(submarines.length+","+bombs.length+","+mines.length);
                    repaint();//重画操作，加载潜艇进入页面
                }
        }, interval, interval);//定时计划表


    }

    /**重写paint 系统自己调用*/
    public void paint(Graphics g) {//每10毫秒走一次
        switch (state) {
            case GAME_OVER:
                Images.gameover.paintIcon(null, g, 0, 0);//调用画笔
                break;
            case RUNNING:
                Images.sea.paintIcon(null, g, 0, 0);//调用画笔
                ship.paintImage(g);//画战舰

                for (SeaObject submarine : submarines) {
                    submarine.paintImage(g);//画潜艇
                }
                for (Mine mine : mines) {
                    mine.paintImage(g);//画水雷
                }
                for (Bomb bomb : bombs) {
                    bomb.paintImage(g);//画炸弹（下）
                }
                /*for (Bomb bomb : bombs1) {
                    bomb.paintImage(g);//画炸弹（上）
                }*/
                g.drawString("SCORE:" + score, 200, 50);
                g.drawString("LIFE:" + ship.getLife(), 400, 50);
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        World world = new World();
        world.setFocusable(true);
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        //系统自己调用paint();
        frame.setVisible(true);
        //启动程序
        world.action();
    }
}