package StaticTest.WrapperDemo;
/**
 * 包装类
 */

import java.util.Scanner;
import java.util.Vector;

public class ScoreTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Vector v = new Vector();
        int maxScore = 0;
        for (; ; ) {
            System.out.println("输入成绩：");
            int score = sc.nextInt();
            if (score < 0) {
                break;
            }
            if (score > 100) {
                System.out.println("成绩非法，重新输入");
                continue;
            }
            //将基本类型转换为包装类
            v.addElement(score);//自动装箱

            if (maxScore < score) {
                maxScore = score;
            }
        }
        char level;
        for (int i = 0; i < v.size(); i++) {
            Object objects = v.elementAt(i);

            //将包装类转换为基本类型
            int score = (int) objects;

            if (maxScore - score <= 10) {
                level = 'A';
            } else if (maxScore - score <= 20) {
                level = 'B';
            } else if (maxScore - score <= 30) {
                level = 'C';
            } else {
                level = 'D';
            }
            System.out.println("student " + i + "score is" + score + "level is" + level);
        }
    }
}
