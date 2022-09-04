package jihe.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LIstDemo {
    public static void main(String[] args) {
        List<String>  list=new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        for (int i=0;i<list.size();i++){
            System.out.println("i = " +list.get(i));
        }
        //迭代器
        Iterator<String> it=list.iterator();
        while (it.hasNext()){
            System.out.println("it = " + it.next());
        }
        //增强for
        for (String s:list){
            System.out.println("s = " + s);
        }
        System.out.println(list);
        System.out.println("-------------------");
        list.set(0,"four");
        System.out.println(list);
        list.add(3,"five");
        System.out.println(list);
    }
}
