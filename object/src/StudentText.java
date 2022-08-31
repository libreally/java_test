public class StudentText {
    public static void main(String[] args) {
        Student1[] stu=new Student1[20];//对象数组
        for (int i=0;i<stu.length;i++){
            //给数组元素赋值
            stu[i]=new Student1();
            //给student对象的属性赋值
            stu[i].number=(i+1);
            stu[i].state=(int)(Math.random()*(6-1+1)+1);//年级
            stu[i].score=(int)(Math.random()*(100 +1));
        }
        for (Student1 student : stu)
            System.out.println(student.info());
        for (Student1 student1 : stu) {
            if (student1.state == 3) {
                System.out.println(student1.info());
            }
        }
        System.out.println("***************************");
        for (int i=0;i<stu.length-1;i++)
            for (int j=0;j< stu.length-1-i;j++){
                if (stu[j].score>stu[j+1].score){
                    Student1 temp=stu[j];
                    stu[j]=stu[j+1];
                    stu[j+1]=temp;
                }
            }
        for (Student1 student1 : stu)
            System.out.println(student1.info());
    }
}

class Student1{
    int number;
    int score;
    int state;
public String info(){
    return number+","+state+","+score;
}
}