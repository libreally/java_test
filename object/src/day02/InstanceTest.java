package day02;

public class InstanceTest {
    public static void main(String[] args) {
        InstanceTest instanceTest=new InstanceTest();
        instanceTest.method(new Student());
    }
    public void method(Person person){
        String info=person.getInfo();
        if(person instanceof Graduate){
            System.out.println("a graduated student");
            System.out.println("a student");
            System.out.println("a person");
        }else if (person instanceof Student){
            System.out.println("a student");
            System.out.println("a person");
        }else{
            System.out.println("a person");
        }
    }
}
class Person{
    protected String name="Person";
    protected int age = 50;
    public String getInfo(){
        return "name"+name+"\n"+"age"+age;
    }
}
class Student extends Person{
    protected String school="pku";
    public String getInfo(){
        return "name"+name+"\n"+"age"+age+"\n"+"school"+school;
    }
}
class Graduate extends Student{
    public String major="it";
    public String getInfo(){
        return "name"+name+"\n"+"age"+age+"\n"+"school"+school+"\n"+"major"+major;
    }
}
