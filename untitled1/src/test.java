import java.util.Scanner;

public class test {
    public static void main(String[] args){
        Scanner N=new Scanner(System.in);
        int i=N.nextInt();
        int j=N.nextInt();
        int max;
        if(i>j)
            max=i;
        else
            max=j;
        System.out.println("最大数是："+max);

    }
}
