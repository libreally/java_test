package jihe;

import java.util.*;

/**
 * 增强for
 * for（元素类型 变量名：几个或数组)
 */
public class ForDemo {
    public static void main(String[] args) {
        String[] arr = {"one", "one", "one", "one", "one", "one"};
        for (String x : arr) {
            System.out.println(x);
        }
        //asList()方法返回Arrays定义的内部的类ArrayList，ArrayList直接引用给定数组
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
        System.out.println("*****************************");
        //改变数组时 list也改变
        arr[1] = "six";
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
        System.out.println("*****************************");

        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        //c.add(123)违背c指定的Sting泛型
         /*
         Iterator<String> it=c.iterator();
        while(it.hasNext()){
            String s=(String)it.next();
            System.out.println(s);
        }*/
        //集合中元素类型为Object
        for (Object x : c) {
            System.out.println(x);

        }
        //集合转数组
        TreeSet<String> treeSet = new TreeSet<>();
        //测试集合的有序性
        treeSet.add("aaa");
        treeSet.add("bbb");
        treeSet.add("eee");
        treeSet.add("ddd");
        String[] array1 = (String[]) treeSet.toArray();
        for (Object object : array1) {
            System.out.printf("for each:%s\n", object);

        }
    }
}
