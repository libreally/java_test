package StringDemo;

/**
 * StringBuilder是专门用于修改字符串的一个类，内部维护一个可变的char数组，
 * 所做操作都是在这个数组之上进行的，并提供了修改方法：
 * * append()增加内容
 *  * delete()删除内容
 *  * replace()替换内容
 *  * insert（）插入内容
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        String st="好好学习java";
        StringBuilder builder=new StringBuilder(st);//好好学习java
        System.out.println("builder = " + builder);
        StringBuilder builder2=new StringBuilder();//空字符串
        System.out.println("builder2 = " + builder2);

        StringBuilder sb = new StringBuilder(10);//长度为10的字符串数组
        sb.append("Runoob..");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.replace(6,8,"--");//（6，8]的内容替换
        System.out.println(sb);
        sb.insert(8, "Java");
        System.out.println(sb);
        sb.delete(6,8);//[6,8)
        System.out.println(sb);
    }
}
