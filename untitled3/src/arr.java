/*求数值型数组中的最大值，最小值，平均值、总值（随机数）*/
public class arr {
    public static void main(String[] args) {
        int[] a=new int[10];
        for (int i =0;i<a.length;i++)
        {
            a[i] = (int) (Math.random() * (99 - 10 + 1) + 10);
        }
        //输出随机数数组
        for (int k : a) {
            System.out.print(k+"  ");
        }
        System.out.println();
        //求最大值
        int MaxValue=a[0];//第一个元素
        for (int j =1;j<a.length;j++)//从第二元素开始比较
        {
            if (MaxValue < a[j])
            {
                MaxValue = a[j];
            }
        }
        System.out.println("最大值是："+MaxValue);
        System.out.println();
        //求最小值
        int MinVolue=a[0];
        for(int i=1;i<a.length;i++)
        {
            if (MinVolue>a[i])
            {
                MinVolue=a[i];
            }
        }
        System.out.println("最小值是："+MinVolue);
        System.out.println();
        //求最和值
        int sum = 0,ave;
        for (int j : a) {
            sum += j;
        }
        System.out.println("和为："+sum);
        System.out.println();
        //求最平均值
        ave=sum/a.length;
        System.out.println("平均值为："+ave);
        System.out.println();
    }

}
