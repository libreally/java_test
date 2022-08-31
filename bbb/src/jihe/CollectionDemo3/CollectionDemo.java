package jihe.CollectionDemo3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 迭代器使用Iterator
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection c=new ArrayList();
       /* Point p=new Point(1,2);
        c.add(p);
        System.out.println(p);//Point{x=1, y=2}
        System.out.println(c);//[Point{x=1, y=2}]*/
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        System.out.println(c);
        //并非所有集合都有下标，使用迭代器对集合遍历
        //boolean hasNext()询问是否有下一个元素可供迭代
        //迭代器默认开始位置是在集合第一个元素之前
        //Object next()迭代器向后移动一个位置指向下一个元素并获取
        //获取集合c的迭代器
        Iterator it=c.iterator();//获取集合c的迭代器
        while(it.hasNext()){//若有下一个元素

            String str=(String)it.next();//取下一个元素
            if("#".equals(str)){
                //c.remove(str);//迭代器遍历过程不能通过集合方法增删元素，否则会抛出异常
                it.remove();//删除元素#
            }
            System.out.println(str);
        }
        /*for (Object o : c) {//若有下一个元素

            String str = (String) o;
            System.out.println(str);

        System.out.println(c);*/
    }
}
