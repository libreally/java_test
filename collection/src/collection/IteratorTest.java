package collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    @Test
    public void test(){
        Collection<Object> col=new ArrayList<>();
        col.add(123);
        col.add(456);
        col.add("Tom");
        col.add(false);
        col.add(new Person("jack",44));
        //迭代器
        Iterator<Object> iterator = col.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            if ("Tom".equals(next)){
                iterator.remove();
            }
        }
        iterator = col.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Collection<Object> col=new ArrayList<>();
        col.add(123);
        col.add(456);
        col.add("Tom");
        col.add(false);
        col.add(new Person("jack",44));

        for (Object d:col){
            System.out.println(d);
        }
    }
}
