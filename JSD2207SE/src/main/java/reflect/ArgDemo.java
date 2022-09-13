package reflect;

import java.util.Arrays;

/**
 * JDK5之后推出了一个新特性:变长参数
 */
public class ArgDemo {
    public static void main(String[] args) {
        /*
            变长参数是编译器认可的，最终会被编译器改为数组
            传参时改为:
            dosome(1,new String[]{});
            dosome(1,new String[]{"a"});
            dosome(1,new String[]{"a","b"});
            dosome(1,new String[]{"a","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b"});

            方法定义会被改为
            public static void dosome(int a,String[] s){
         */
        dosome(1);
        dosome(1,"a");
        dosome(1,"a","b");
        dosome(1,"a","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b");
    }
    //变长参数在一个方法中必须是最后一个参数
    public static void dosome(int a,String... s){
        System.out.println(s.length);
        System.out.println(Arrays.toString(s));
    }
}





