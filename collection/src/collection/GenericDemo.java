package collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 泛型用来指定集合中元素的类型
 * 防止别的类型进入出现强转时出错
 */
public class GenericDemo {

    @Test
    public void test() {
        //指定元素泛型为String
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        for (String str : c) {
            System.out.println("str = " + str);
        }
    }
    @Test
    public void test2(){
        HashMap<String ,Integer> map = new HashMap<>();
        map.put("aa",344);
        map.put("bb",44);
        map.put("cc",55);
        Set<Map.Entry<String,Integer>> entry=map.entrySet();
       /* for (Map.Entry<String,Integer> m:entry) {
            System.out.println("m = " + m);
        }*/
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "----->" + value);
        }


    }

}
