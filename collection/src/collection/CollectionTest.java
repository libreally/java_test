package collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Collection工具类
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection<Object> collection=new ArrayList<>();
        //添加元素
        collection.add("sss");
        collection.add("bbb");
        collection.add("rrr");
        collection.add("ttt");
        collection.add("yyy");
        //size（）获取元素个数
        System.out.println(String.valueOf(collection.size()));//自动拆箱
        //addAll(Collection collection1)将集合collection1中的元素添加到当前集合
        Collection<Object> collection1=new ArrayList<>();
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
        Collection<Object> col=new ArrayList<>();
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
        Collection<Object> col1=new ArrayList<>();
        col1.add(123);
        col1.add(456);
        col1.add("333");
        System.out.println(col.containsAll(col1));
    }
    @Test
    public void test3(){
        Collection<Object> col=new ArrayList<>();
        col.add(123);
        col.add(456);
        col.add(new String("Tom"));
        col.add(false);
        col.add(new Person("jack",44));
        System.out.println(col);
        //remove（Object obj）移除元素
        col.remove(123);
        System.out.println(col);
        Collection<Object> col1=new ArrayList<>();
        Collection <Object>col2= Arrays.asList(123,355);
        col1.add(123);
        col1.add(456);
        col1.add("333");
        //removeAll(Object obj)从当前集合中移除col1中的所有元素
        col.removeAll(col1);
        System.out.println(col);
    }
    @Test
    public void test4(){
        Collection<Object> col=new ArrayList<>();
        col.add(123);
        col.add(456);
        col.add(new String("Tom"));
        col.add(false);
        col.add(new Person("jack",44));
        //获取交集
        Collection<Object> col2= Arrays.asList(123,355);
        col.retainAll(col2);
        System.out.println(col);
    }
    @Test
    public void test5(){
        Collection<Object> col=new ArrayList<>();
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
    @Test
    public void test6(){
        List<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(23);
        list.add(15);
        list.add(42);
        list.add(-123);
        System.out.println(list);
        //翻转list中元素数据
        /*
        Collections.reverse(list);
        System.out.println(list);
        //对list集合元素进行随机排序
        Collections.shuffle(list);
        System.out.println("list = " + list);
        //根据元素的自然顺序对指定list集合元素按升序排序//根据指定的Comparator产生的顺序对list集合元素进行排序
        Collections.sort(list);
        System.out.println("list = " + list);
        //swap(list,i,j)将指定list集合中的i处元素与j处元素交换
        Collections.swap(list,1,3);
        System.out.println("list = " + list);
        //max(list),min(list)根据元素的自然排序返回指定集合的最大值/最小值
        //max(list,Comparator),min(list,Comparator)根据指定的Comparator产生的顺序返回指定集合的最大值/最小值
        Integer max = Collections.max(list);
        System.out.println("max = " + max);
        //frequency(list,Object)返回指定几个中元素的出现次数
        int frequency = Collections.frequency(list, 42);
        System.out.println("frequency = " + frequency);*/
        //copy(dest,src)将指定内容src复制到dest中
        List<Object> dest=new ArrayList<>();
        dest.add(333);
        dest.add(333);
        dest.add(333);
        dest.add(333);
        dest.add(333);
        Collections.copy(dest,list);
        System.out.println("dest = " + dest);
    }
}
