package jihe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 泛型用来指定集合中元素的类型
 */
public class GenericDemo {
    public static void main(String[] args) {
        //指定元素泛型为String
        Collection<String> c=new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");

        Iterator<String> it=c.iterator();//迭代器
        while (it.hasNext()){
            String str=it.next();
        }

        for (String str:c){
            System.out.println("str = " + str);
        }
    }
}
