package com;
import java.util.Scanner;
public class gg {
    public static void main(String[] args)
    {
        Scanner x=new Scanner(System.in);
        System.out.println("输入学生人数：");
        int number=x.nextInt();
        int[] score=new int[number];
        System.out.println("输入成绩：");
        //给数组元素赋值
        for (int i=0;i< score.length;i++)
        {
            score[i]=x.nextInt();
        }
        //获取数组中元素的最大值
        int maxScore=0;
        for (int j : score) {
            if (maxScore < j) {
                maxScore = j;
            }
            System.out.println("最高成绩是：" + maxScore);
        }
        //根据每个学生成绩与最高分的差值，得到每个学生的登记并输出登记和成绩
        
        char level = 0;
        for (int j : score)
            if (maxScore - j <= 10) {
                level = 'A';
            } else if (maxScore - j <= 20) {
                level = 'B';
            } else if (maxScore - j <= 30) {
                level = 'C';
            } else {
                level = 'D';
            }
        int i = 0;
        System.out.println("student "+i+ "score is"+score[i]+",grade is "+level);
    }
}
