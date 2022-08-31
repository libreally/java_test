package jihe.CollectionDemo4;

import java.util.*;

/**
 * 数组转化为集合
 * 数组工具类Arrays提供静态方法asList（）
 *
 */
public class ArrToListDemo {
    public static void main(String[] args) {
        String[] arr = {"one", "two", "three", "four", "five"};
        System.out.println("arr = " + arr);
        //asList()方法返回Arrays定义的内部的类ArrayList，
        // ArrayList直接引用给定数组(ArrayList中存的是数组的地址)
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
        System.out.println("*****************************");
        //改变数组时 list也改变
        //如果是数组转化为集合，集合中不会自动扩容缩容，不支持这样的操作
        arr[1] = "six";
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
        System.out.println("*****************************");
        //如果我们需要增删元素，可另行创建一个集合同时包含list集合的元素即可
        List<String> list2=new ArrayList<>(list);
        list2.add("seven");
        System.out.println("list2 = " + list2);
        System.out.println("*****************************");

    }
}
