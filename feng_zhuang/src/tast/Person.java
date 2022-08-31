package tast;

public class Person {
    private int age;
    public void setAge(int a){
        if(a<0||a>130){
            System.out.println("传入非法数据");
            return;
        }
        age=a;
    }
    public int getAge(){
        return age;
    }
}
