public class erfen {
    public static void main(String[] args){
        //折半查找，必须先排序再查找
        int[] array=new int[]{-23,-20,0,5,6,8,9,15,78};
        int dest=-20;
        dest=50;
        int head=0;
        int end=array.length-1;
        boolean ifFlag=true;
        while (head<=end){
            int middle=(head+end)/2;
            if (dest==array[middle]){
                System.out.println("找到了"+middle);
                ifFlag=false;
                break;
            }
            else if(dest<array[middle]){
               end=middle-1;
            }
            else{
                head=middle+1;
            }
        }
        if (ifFlag){
            System.out.println("没找到");
        }
    }
}
