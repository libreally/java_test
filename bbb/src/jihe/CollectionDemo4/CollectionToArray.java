package jihe.CollectionDemo4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

/**
 * 集合转数组
 * toArray()
 */
public class CollectionToArray {
    public static void main(String[] args) {

        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        System.out.println("c = " + c);
        String[] array=c.toArray(c.toArray(new String[c.size()]));

    }
}
