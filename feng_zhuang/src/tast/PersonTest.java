package tast;

public class PersonTest {
    public static void main(String[] args) {
        Person p1=new Person();
        //p1.age=1;编译不通过
        p1.setAge(12);
        System.out.println("年龄为："+p1.getAge());
    }
}
