package jihe.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortListDemo {
    public static void main(String[] args) {
        Random rand=new Random();
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(rand.nextInt(100));
        }
        System.out.println("原始集合"+list);
        //自然排序
        Collections.sort(list);
        System.out.println("sort："+list);
        //翻转list集合
        Collections.reverse(list);
        System.out.println("翻转"+list);
    }
}
