package map;

import collection.User;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MapTest {
    @Test
    public void test1() {
        Map<String,Integer> map = new HashMap<>();
        //修改/添加
        map.put("aa", 123);
        //map.put("aa", 456);会将前面的替换
        map.put("cc", 123);
        map.put("dd", 123);
        System.out.println(map);//{aa=123, cc=123, dd=123}

        Map<String,Integer> map1 = new HashMap<>();
        map1.put("aa",213);//加入别的map中时，若有相同的key则将另一个的value替换
        map1.put("vv",234);

        map.putAll(map1);
        System.out.println(map);//{aa=213, cc=123, dd=123, vv=234}

        //移除,没有返回null
        map.remove("cc");
        System.out.println(map);//{aa=213, dd=123, vv=234}
        //清空
        map.clear();
        System.out.println(map);//清空数据

    }

    @Test
    public void test2() {
        Map<String,Integer> map = new HashMap<>();

        map.put("aa", 123);
        map.put("cc", 123);
        map.put("dd", 123);
        //是否包含key/value
        boolean cc = map.containsKey("cc");
        boolean value=map.containsValue(123);
        System.out.println(cc+","+value);

        //返回键值对个数
        int size = map.size();
        System.out.println(size);
        //判断是否为空
        boolean empty = map.isEmpty();
        System.out.println("empty = " + empty);

    }
    /**
     * 元视图的操作方法
     * Set keySet()  返回所有key构成的Set集合
     * Collection values()  返回所有value构成的Collection集合
     * Set entrySet ()  饭返回所有key-value对构成的Set集合
     */
    @Test
    public void test3(){
        Map<String,Integer> map=new HashMap<>();
        map.put("aa",355);
        map.put("bb",56);
        map.put("cc",88);
        //便利所有的key集
        Set<String> set = map.keySet();
        for (String s:set) {
            System.out.println("s = " + s);
        }
        //返回所有value构成的Collection集合
        Collection<Integer> values = map.values();
        Iterator<Integer> iterator = values.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //返回map键值对
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println("entries = " + entries);

        Set<Map.Entry<String, Integer>> entries1 = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator1 = entries1.iterator();
        while(iterator1.hasNext()){

            Map.Entry<String, Integer> next = iterator1.next();
            System.out.println(next);
        }

    }
        /**
         * 处理配置文件Properties
         */
    /**
     * 向TreeMap 中添加键值对，要求key必须师由同一个类创建的对象
     * 因为要按照key进行排序：自然排序、定制排序
     */
    @Test
    public void test4(){
        TreeMap<Object,Integer> map=new TreeMap<>();
        User u1=new User("Tom",64);
        User u2=new User("jack",23);
        User u3=new User("ross",35);
        User u4=new User("jerry",89);
        map.put(u1,13);
        map.put(u2,55);
        map.put(u3,77);
        map.put(u4,66);

        Set<Map.Entry<Object, Integer>> entries = map.entrySet();
        /*Iterator<Map.Entry<Object, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Object, Integer> next = iterator.next();
            Object key = next.getKey();
            Integer value=next.getValue();
            System.out.println(next.getKey()+"------------->"+next.getValue());
        }*/


    }



}
