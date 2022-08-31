package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("小泽老师");
        list.add("传奇");
        list.add("苍老师");
        System.out.println(list);
        Collections.sort(list, Comparator.comparingInt(String::length));
        System.out.println(list);
    }
}
