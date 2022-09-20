package exe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 在List中去除重复数字值，要求尽量简单
 * 将list中数据加入set中，因为set是无序的且不重复的
 */
public class Test1 {
    public static List<Integer> duplicateList(List<Integer> list){
        HashSet<Integer> set = new HashSet<>(list);
        return new ArrayList(set);
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(4);
        List<Integer> list2=duplicateList(list);
        for (Object integet:list2) {
            System.out.println(integet);
        }
    }
}
