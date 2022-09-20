package exe;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Test2 {
    @Test
    public void test1() {
        HashSet<Object> set = new HashSet<>();
        Person p1 = new Person(1001, "aa");
        Person p2 = new Person(1002, "bb");

        set.add(p1);
        set.add(p2);
        System.out.println(set);
        System.out.println("***************");

        p1.setName("cc");
        set.remove(p1);
        System.out.println(set);//set使用的是hash值，remove()没有移除
        System.out.println("***************");

        set.add(new Person(1001, "cc"));
        System.out.println(set);
        System.out.println("***************");

        set.add(new Person(1001, "aa"));
        System.out.println(set);
        /*
        *   [Person{id=1002, name='bb'}, Person{id=1001, name='aa'}]
            ***************
            [Person{id=1002, name='bb'}, Person{id=1001, name='cc'}]
            ***************
            [Person{id=1002, name='bb'}, Person{id=1001, name='cc'}, Person{id=1001, name='cc'}]
            ***************
            [Person{id=1002, name='bb'}, Person{id=1001, name='cc'}, Person{id=1001, name='cc'}, Person{id=1001, name='aa'}]
*/
    }
}
