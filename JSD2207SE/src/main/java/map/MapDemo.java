package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找表
 * 本身是一个接口，体现为多行两列表，左列为key 右列为value
 *
 */
public class MapDemo {
    public static void main(String[] args) {


        Map<String ,Integer> map=new HashMap<>();
        /**
         * map特点：key不能重复，如果使用重复key则是替换value值
         */
        map.put("生物",44);
        map.put("语文",55);
        map.put("数学",55);
        map.put("英语",55);
        map.put("物理",55);
        map.put("化学",55);
        System.out.println(map);
        map.put("生物",55);//替换value值
        System.out.println(map);
        //size（）返回当前map中键值对个数
        int size=map.size();
        System.out.println("size = " + size);
        //get（）从map中获取元素对应的value,没有时返回null
        Integer value = map.get("英语");
        System.out.println("value = " + value);
        Integer value2 = map.get("体育");
        System.out.println("value2 = " + value2);
        //remove（）删除元素,返回值为对应key的value值
        map.remove("英语");
        System.out.println(map);
        //containsKey()判断是否包含给定的key
        //containsValue判断是否包含给定的value
        boolean b1 = map.containsKey("体育");
        boolean b = map.containsValue(97);
        System.out.println("b = " + b);
        System.out.println("b1 = " + b1);

        map.clear();
        System.out.println("map = " + map);
    }
}
