public class ff implements B{
 int k=20;

    public static void main(String[] args) {
        int i;
        B c1=new ff();
        i=c1.k;
        System.out.println(i);
    }
}
interface B{
    int k=10;
}