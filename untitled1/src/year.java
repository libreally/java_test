import java.util.Scanner;
public class year {
    public static void main(String[] args){
        Scanner TOTAL =new Scanner(System.in);
        int year=TOTAL.nextInt();
        int month=TOTAL.nextInt();
        int day=TOTAL.nextInt();
        boolean leap = year%400==0||year%100!=0&&year%4==0;
        int total = year - 1980 + (year - 1980 + 3) / 4;
        for(int i=month-1;i>0;i--)
        {
            switch (i) {
                case 1, 3, 5, 7, 8, 10 ,12-> total += 31;
                case 4, 6, 9, 11 -> total += 30;
                case 2 -> total += leap ? 29 : 28;
            }
        }
        total+=day;
        int week=1;
        week=(week+total)%7;
        System.out.println(year+"年"+month+"月"+day+"日   星期");
        switch (week) {
            case 0 -> System.out.println("日");
            case 1 -> System.out.println("一");
            case 2 -> System.out.println("二");
            case 3 -> System.out.println("三");
            case 4 -> System.out.println("四");
            case 5 -> System.out.println("五");
            case 6 -> System.out.println("六");
        }
    }
}
