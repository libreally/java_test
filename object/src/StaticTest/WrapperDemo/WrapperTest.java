package StaticTest.WrapperDemo;


import org.junit.jupiter.api.Test;

/**
 * 包装类的使用
 */
public class WrapperTest {
    //基本数据类型 ----》包装类：调用包装类的构造器
    @Test
    public void test1(){
        int num1=10;
        Integer in1= num1;//自动装箱
        System.out.println(in1.toString());


        Order order=new Order();
        System.out.println(order.isMale);
        System.out.println(order.isFemale);
    }
    //包装类转换为基本数据类型
    @Test
    public void test2(){
        Integer int1= 12;//自动拆箱
        int i1= int1;
        System.out.println(i1+1);
    }

    /**
     * 基本数据类型、包装类转换为String类型
     */
    @Test
    public void test3(){
        //方式1：链接运算
        int num1=10;
        String str1=num1+"";
        //方式2：调用String的valueOf(xxxxxx)
        float f1=12.3f;
        String str2=String.valueOf(f1);
    }

    /**
     * String类型转换为基本数据类型、包装类
     * 强制转换时必须满足子父类关系
     */
    @Test
    public void test4(){
        //方法使用  类型.parseInt(xxx)
        String s1="123";
        int num=Integer.parseInt(s1);
        System.out.println(num+1);
    }
    class Order{
        boolean isMale;//这是基本类型，默认值为false
        Boolean isFemale;//这是一个类 调用后默认值为null
    }
}
