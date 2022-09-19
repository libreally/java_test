package set;

import collection.Person;
import collection.User;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * set 存无序的不可重复的数据
 * 向set中添加数据时，其所在的类一定要重写HashCode() 和 equals()方法
 * 相等的对象一定要有相等的散列码
 */
public class SetTest {
    @Test
    public void test1(){
        Set<Object> set=new HashSet<>();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",23));
        set.add(new User("Nick",67));
        set.add(new User("Nick",67));
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Set<Object> set=new LinkedHashSet<>();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",23));
        set.add(new User("Nick",67));
        set.add(new User("Nick",67));
        for (Object o : set) {
            System.out.println(o);
        }

    }
    @Test
    public void test3(){
        TreeSet<Integer> set=new TreeSet<>();
        //不可添加不同类的对象,
        //按照添加对象的指定属性，进行排序
        set.add(34);
        set.add(54);
        set.add(84);
        set.add(39);
        for (Integer o : set) {
            System.out.println(o);//34 39 54 84
        }
    }
}
