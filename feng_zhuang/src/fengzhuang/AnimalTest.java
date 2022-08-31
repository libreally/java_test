package fengzhuang;

import javax.swing.*;

public class AnimalTest {
    public static void main(String[] args) {
        Animal a=new Animal();
        a.name="dashing ";
        a.age=1;
        a.setLegs(4);
        a.show();
    }

}

class Animal{
    String name;
    int age;
//******************************封装
    /**
     * 封装性的体现：
     * 1.将属性私有化，提公共的方法获取getxxx()和设置setxxx（）方法
     * 2.不对外暴露的私有的方法
     * 3.需要配合权限修饰符
     */
    private int legs;
    //对属性的设置set
    public void setLegs(int l){
        if(l>=0&&l%2==0)
            legs=1;
        else
            legs=0;
    }
    //对属性的获取get
    public int getLegs(int i){
        return legs;
    }
    //**************************
    public void eat(){
        System.out.println("动物进食");
    }
    public  void show(){
        System.out.println("name="+name+",age="+age+",legs="+legs);
    }
}