package list;

import org.junit.jupiter.api.Test;

import java.util.*;

public class LIstDemo {
    public static void main(String[] args) {
        List<String>  list=new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        //遍历
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println("next = " + next);
        }
        for (String s:list) {
            System.out.println("s = " + s);
        }
        //add()向指定位置添加元素
        list.add(3,"five");
        System.out.println(list);
        System.out.println("*******************");
        //get()按照索引获取元素
        System.out.println(list.get(2));
        System.out.println("*******************");
        //indexOf(Object obj)返回obj第一次出现的位置
        int three = list.indexOf("three");
        System.out.println("three 位置： " + three);
        System.out.println("*******************");
        //lastIndexOf(Object obj)返回obj最后一次出现的位置
        System.out.println(list.lastIndexOf("two"));
        System.out.println("*******************");
        //remove(index)移除指定位置的元素，并返回此元素
        String remove = list.remove(1);
        System.out.println("remove = " + remove);
        System.out.println("*******************");
        //set(index,ell)设置指定位置的元素为ell
        list.set(0,"four");
        System.out.println(list);
        System.out.println("*******************");
        //subList(start,end)返回从start到end位置的子集
        List<String> strings = list.subList(1, 3);
        System.out.println("strings = " + strings);

    }
    @Test
    public void test(){
        List<String>  list=new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        List list1=Arrays.asList(1,2,3);
        list.addAll(list1);
        System.out.println(list);
    }
   /**
    * 提供一个方法 用于遍历HashMap<String,String>中的所有value
    并存放在list中返回*/
   public List<String> getValueList(HashMap<String,String> map){
       ArrayList<String> list=new ArrayList<>();
       Collection<String> values = map.values();
       for (String value:values) {
           list.add(value);
       }
       return list;
   }
}
