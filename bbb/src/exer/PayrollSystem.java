package exer;

import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入月份");
        int month=sc.nextInt();
        Employee[] emps = new Employee[2];
        emps[0]=new SalariedEmployee("make",1002,new MyDate(1992,2,26),10000);
        emps[1]=new HourlyEmployee("HFN",2001,new MyDate(19921,1,2),60,240);

        for (Employee emp : emps) {
            System.out.println(emp);
            double salary = emp.earnings();
            System.out.println("月工资为：" + salary);

            if (month==emp.getBirthday().getMonth()){
                salary=salary+100;
                System.out.println("happy birthday to you! ");
                System.out.println("月工资为：" + salary);
            }
        }

    }
}
