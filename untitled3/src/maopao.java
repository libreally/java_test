import java.util.Arrays;
//冒泡排序
public class maopao {
    public static void main(String[] args) {
        int[] arr=new int[]{-20,-65,-78,55,2,5,6,48,98,65};
        for (int i=0;i<arr.length;i++)
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }

            System.out.println(Arrays.toString(arr));//输出数组数据Arrays.toString()
        Arrays.sort(arr);//对数组进行排序
        System.out.println(Arrays.toString(arr));
        Arrays.fill(arr,5);//将指定值填充到数组
        System.out.println(Arrays.toString(arr));
        //Arrays.binarySearch()对排序后的数组进行二分法查找指定值
        int[] arr1=new int[]{4,6,5,8,1,4,-4,-6};
        Arrays.sort(arr1);//对数组进行排序
        System.out.println(Arrays.toString(arr1));
        int index= Arrays.binarySearch(arr1,7);
        if (index>=0){
            System.out.println(index);
        }
        else{
            System.out.println("未找到");
        }
    }
}
/**
 *数组常见异常
 * （1）数组角标越界 ArrayIndexOutOfBoundsException
 *  (2)空指针异常  NullPointerException
 */