package list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo2 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<10;i++){
           list.add(i*10);
        }
        System.out.println(list);
        //获取子集
        List<Integer> subList= list.subList(3,8);
        System.out.println("获取子集："+subList);

        for (int i=0;i<subList.size();i++){
            subList.set(i,subList.get(i)*10);
        }
        System.out.println(subList);
        System.out.println(list);
    }
}
