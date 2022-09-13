package map;

import java.util.*;

public class MapDemo2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("生物", 44);
        map.put("语文", 55);
        map.put("数学", 55);
        map.put("英语", 55);
        map.put("物理", 55);
        map.put("化学", 55);
        //Set keySET()将当前map中所有的key以一个set集合形式返回
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println("key = " + key);
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> e : entries) {
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + ":" + value);
        }
        System.out.println("************************************");
        map.forEach((k,v)-> System.out.println(k+":"+v));


        Collection<Integer> values = map.values();
        for (Integer value:values){
            System.out.println("value = " + value);
        }
        Collection<String> c=new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.forEach(e-> System.out.println("e = " + e));

    }
}
