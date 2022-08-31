package StringDemo;

public class StringDemo1 {
    public static void main(String[] args) {
        String str = "  hello world   ";
        System.out.println(str);
        String trim = str.trim();
        System.out.println("trim = " + trim);//去除两边空字符

        String s1="hello123 world123";
        String upperCase = s1.toUpperCase();//将字符串中的字符转换为大写
        System.out.println("upperCase = " + upperCase);
        String lowerCase=s1.toLowerCase();//将字符串中的字符转换为小写
        System.out.println("lower = " + lowerCase);

        String s2="thinking in java";
        boolean startsWith = s2.startsWith("t");//是否以字符t开始
        System.out.println("startsWith = " + startsWith);
        boolean endsWith = s2.endsWith("a");//是否以字符t结束
        System.out.println("endsWith = " + endsWith);

        String s3="thinking in java";
        char charAt = s3.charAt(6);//下标对应的字符
        System.out.println("charAt = " + charAt);

        String s4="happy new year";
        int indexOf = s4.indexOf("h");//找出字符h第一次出现的位置
        int indexOf1=s4.indexOf("a",2);//从下标为2的位置找字符a第一次出现的位置  若找不到则返回-1
        System.out.println("indexOf = " + indexOf);
        System.out.println("indexOf1 = " + indexOf1);
        int lastIndexOf = s4.lastIndexOf("a");//找出字符a最后一次出现的位置
        System.out.println("lastIndexOf = " + lastIndexOf);

        String s5="www.baidui.com";
        String substring = s5.substring(4, 10);//截取指定范围内的字符串【4.10）
        System.out.println("substring = " + substring);
        // 类型.valueOf()将其他类型转换为某类型
        int a=123;
        String s6=String.valueOf(a);//将其他类型转换为String
        System.out.println("s6 = " + s6);
    }
}
