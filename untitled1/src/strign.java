import java.util.Scanner;
public class strign {
    public static void main(String[] args) {
        Scanner score = new Scanner(System.in);
        int n = score.nextInt();
        String d=score.next();
        if (n == 100) {
            System.out.println("车");
        } else if (n > 80 && n < 99) {
            System.out.println("手机");
        } else if (n > 60 && n < 80)
            System.out.println("ipad");
        else
            System.out.println("无");
        System.out.println(d);
    }
}
