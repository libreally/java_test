package collection;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionTest {
    @Test
    public void test1(){
        Collection collection=new ArrayList();
        //添加元素
        collection.add("sss");
        collection.add("bbb");
        collection.add("rrr");
        collection.add("ttt");
        collection.add("yyy");
        //size（）获取元素个数
        System.out.println(String.valueOf(collection.size()));//自动拆箱
        //addAll(Collection collection1)将集合collection1中的元素添加到当前集合
        Collection collection1=new ArrayList();
        collection1.add("fffg");
        collection.addAll(collection1);
        System.out.println(collection);
        //clear（）清空集合元素
        collection1.clear();
        System.out.println(collection1.size());
        //判断集合是否为空
        System.out.println(collection.isEmpty());
    }
    @Test
    public void test2(){
        Collection col=new ArrayList();
        col.add(123);
        col.add(456);
        col.add(new String("Tom"));
        col.add(false);
        col.add(new Person("jack",44));

        ///contains(Object obj)判断集合中是否包含obj
        boolean contains = col.contains(123);
        System.out.println(contains);//true
        System.out.println(col.contains(new String("Tom")));//true
        System.out.println(col.contains(new Person("jack",44)));//false,当person中重写equal方法时为true
        System.out.println("**************************************************");
        //containsAll(Collection col1)判断col1中的所有数据是否在当前集合中
        Collection col1=new ArrayList();
        col1.add(123);
        col1.add(456);
        col1.add("333");
        System.out.println(col.containsAll(col1));
    }
    @Test
    public void test3(){
        Collection col=new ArrayList();
        col.add(123);
        col.add(456);
        col.add(new String("Tom"));
        col.add(false);
        col.add(new Person("jack",44));
        System.out.println(col);
        //remove（Object obj）移除元素
        col.remove(123);
        System.out.println(col);
        Collection col1=new ArrayList();
        Collection col2= Arrays.asList(123,355);
        col1.add(123);
        col1.add(456);
        col1.add("333");
        //removeAll(Object obj)从当前集合中移除col1中的所有元素
        col.removeAll(col1);
        System.out.println(col);
    }
    @Test
    public void test4(){
        Collection col=new ArrayList();
        col.add(123);
        col.add(456);
        col.add(new String("Tom"));
        col.add(false);
        col.add(new Person("jack",44));
        //获取交集
        Collection col2= Arrays.asList(123,355);
        col.retainAll(col2);
        System.out.println(col);
    }
    @Test
    public void test5(){
        Collection col=new ArrayList();
        col.add(123);
        col.add(456);
        col.add(new String("Tom"));
        col.add(false);
        col.add(new Person("jack",44));
        //集合------》数组 toArray()
        Object[] objects = col.toArray();
        for (Object obj:objects){
            System.out.println(obj);
        }
        System.out.println("**************************************");
        //数组------》集合 Arrays.asList()
        String[] arr={"SA","SF","CF"};
        List<String> ints = Arrays.asList(arr);
        System.out.println(ints);
    }
}
