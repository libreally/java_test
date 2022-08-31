import java.util.Arrays;
//数组反转
public class reversal {
    public static void main(String[] agrs){
        int[] arr=new int[]{1,2,3,4,5,6,7};
//        //方法一
//        for (int i=0;i<arr.length/2;i++){
//            int temp=arr[i];
//            arr[i]=arr[arr.length-i-1];
//            arr[arr.length-i-1]=temp;
//        }
//        //方法二
        for (int i=0,j=arr.length-1;i<j;i++,j--){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
