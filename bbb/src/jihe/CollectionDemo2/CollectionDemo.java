package jihe.CollectionDemo2;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection c1=new ArrayList();
        c1.add("java");
        c1.add("c++");
        c1.add(".net");
        System.out.println(c1);

        Collection c2=new ArrayList();
        c2.add("android");
        c2.add("ios");
        c2.add("java");
        System.out.println(c2);

        //addAll(Collection c)将参数给定的集合中的所有元素添加到当前集合中
        c1.addAll(c2);//将c2中的元素加入c1
        System.out.println(c1);
        System.out.println(c2);

        Collection c3=new ArrayList();
        c3.add("android");
        c3.add("c++");
        c3.add("PHP");
        System.out.println(c3);
        //c1.containsAll(c3)c1中是否包含c3的所有元素
        boolean contains=c1.containsAll(c3);
        System.out.println("是否包含： " + contains);//false

        /*//取交集,c1仅保留c1 与 c3的共有元素， c3不变
        c1.retainAll(c3);
        System.out.println("取交集"+c1);//[c++,android]
        System.out.println(c3);//[android,c++,PHP]*/
        //删交集,删除c1 与 c3的共有元素， c3不变
        c1.removeAll(c3);
        System.out.println("删交集"+c1);//[java, .net, ios, java]
        System.out.println(c3);//[android,c++,PHP]

    }
}
