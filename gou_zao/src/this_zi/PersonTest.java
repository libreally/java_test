package this_zi;
//this可以修饰、调用：属性、方法、构造器
/*
*this修饰属性和方法：代表当前对象或者当前正在创建的对象
*在类的方法中我们可以使用 this.属性 或 this.方法，调用当前属性或者方法，但是
 我们通常省略。但是当方法的形参和类的属性重名时，必须使用 this.变量
*this调用构造器
  1.可以使用this（形参列表）方式动用本类中的其他构造器
  2.构造器中不能通过this（形参列表）方式调用自己
  3.构造器的调用必须放在构造器内部第一行
*/
public class PersonTest {
    public static void main(String[] args) {
        Person p1=new Person();
        p1.setAge(18);
        System.out.println(p1.getAge());

        //构造器
        Person p2=new Person("jane");
        System.out.println(p2.getName());

    }
}

class Person{

    private String name;
    private int age;
//构造器
    public Person(){
    }
    public Person(String name){
        this();//调用构造器
        this.name=name;
    }


    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
}
