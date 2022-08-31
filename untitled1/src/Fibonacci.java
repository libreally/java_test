 public class Fibonacci {
    public static void main(String[] args) {
        int n = 25;
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        for (int j : fib) {                       //逐元循环 j引用fib中每一个元素
            System.out.println("  " + j);
        }
        System.out.println();
    }
}