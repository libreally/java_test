package lambda;

import java.util.*;

/**
 * 集合排序
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<10;i++){
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        //从大到小
//        Collections.sort(list, new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        Collections.sort(list, (o1,o2)->o2-o1);
//        System.out.println(list);

        list.sort((o1,o2)->o2-o1);
        System.out.println(list);
    }
}
