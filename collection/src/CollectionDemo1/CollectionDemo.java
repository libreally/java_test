package CollectionDemo1;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合中只能添加引用类型
 */
public class CollectionDemo {
    public static void main(String[] args) {
       /* Collection c=new ArrayList();
        //add()添加元素
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        c.add("1");//可重复
        System.out.println(c);//输出集合，重写了toString()方法
        //size()获取集合元素个数
        int size=c.size();
        System.out.println(size);
        //判断集合是否为空
        boolean isEmpty=c.isEmpty();
        System.out.println("是否为空： " + isEmpty);//false
        //clear清空集合
        System.out.println(c);//输出集合
        System.out.println("长度"+c.size());
        System.out.println("是否为空： " + isEmpty);*/


        Collection c=new ArrayList();
        c.add(new Point(1,2));
        c.add(new Point(2,3));
        c.add(new Point(3,4));
        c.add(new Point(4,5));
        c.add(new Point(1,2));
        //当Point类没有toString方法时输出的是地址
        System.out.println(c);
        //contains(p)判断集合中是否包含给定元素p,判断依据是给p是否与集合元素存在equals()为true的情况
        Point p= new Point(1,2);
        boolean contains=c.contains(p);
        System.out.println("是否包含："+contains);//Point类中没有重写equals（）方法时为false，重写后为true
        //从集合中删除元素,
        //从集合中删除与给定元素equals比较为true的元素 若存在重复元素只删除一次
        c.remove(p);
        System.out.println(c);//第一个（ 1, 2）被删除
    }



}
