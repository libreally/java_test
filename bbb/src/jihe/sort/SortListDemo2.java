package jihe.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListDemo2 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("jack");
        list.add("rose");
        list.add("tom");
        list.add("black");
        list.add("jerry");
        System.out.println("原始数据："+list);
        //对英文排序时会按照首字母的ascii码排序，若首字母相同则比较第二位
        Collections.sort(list);
        System.out.println("排序后"+list);

    }
}
