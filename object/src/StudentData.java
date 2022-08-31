
class student{
    String name;
    int age;
    String major;
    String interests;
    public String say(String name,int age,String major,String interests){

        System.out.println(name+age+major+interests);
        return name;//+age+major+interests;
    }
    /**public String say(){

     System.out.println(name+age+major+interests);
     return name;//+age+major+interests;
     }*/
}
public class StudentData {
    public static void main(String[] args) {
        student stu=new student();
        stu.say("王",18,"数学","画画");
       /** stu.age=18;
        stu.name="www";
        stu.major="shu";
        stu.interests="weuis";
        stu.say();
        */
    }
}
