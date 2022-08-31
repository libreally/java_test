package recursion;

/**
 * 递归使用；方法内自己调用自己
 * 1--100之内自然数之和
 */
public class RecursionTest {
    public static void main(String[] args) {

//        int sum=0;
//        for(int i=1;i<=100;i++){
//            sum+=i;
//        System.out.println("sum");

       RecursionTest test=new RecursionTest();
       int sum1=test.getAum(100);
       System.out.println(sum1);
    }
    public int getAum(int n){
        if(n==1)
            return 1;
        else
            return n+getAum(n-1);
    }
}
