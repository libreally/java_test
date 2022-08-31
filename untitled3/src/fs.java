import java.net.SocketOption;
//线性查找
public class fs {
    public static void main(String[] args) {
        String[] dest= new String[]{"aa","bb","cc","dd"};
        String deff="dd";
        //deff="gg";
        boolean isFlag=true;
        for (int i=0;i<dest.length;i++){
            if (deff.equals(dest[i])){
                System.out.print("找到指定位置："+i);
                isFlag=false;
                break;
            }
        }
        if (isFlag){
            System.out.println("没有找到");
        }
    }
}
