package StringDemo;

public class StringDemo {
    public static void main(String[] args) {
        /**
         * String s = new String("hello");
         * 创建了两个对象
         * 1.字面量 "hello"
         * 2.new String()会创建一个对象
         */
        String str00 = "i lvoe java";
        int len = str00.length();
        System.out.println(len);

        String s=new String("hello");
        String s1 = "hello";//服用常量池中的
        System.out.println(s==s1);//false
        System.out.println(s.equals(s1));//true

        String s2= "    hello world   ";
        System.out.println(s2);
        System.out.println(s2.trim());
        //trim（）去除两边的空白字符
        s2=s2.trim();
        System.out.println(s2);
        //toUpperCase将字符串中的英文转换为大写
        String str = "我爱java";
        String ss=str.toUpperCase();
        System.out.println(ss);
        //toLowerCase()转换为全小写
        String sss=ss.toLowerCase();
        System.out.println(sss);

        //startsWith(xx)字符串是否是以xx开始的
        String s3="thinking in java";
        boolean starts=s3.startsWith("think");
        System.out.println(starts);
        //endsWith(xx)字符串是否是以xx结束的
        boolean ends=s3.endsWith("java");
        System.out.println(ends);
        //charAt()返回当前字符串指定位置上的字符
        char c=s3.charAt(2);
        System.out.println(c);
        //indexOf(xx)找当前字符串中xx第一次出现的位置 找不到返回-1
        int index=s3.indexOf("i");
        System.out.println(index);
        //LastIndexOf(xx)找当前字符串中xx最后一次出现的位置
        int last=s3.lastIndexOf("i");
        System.out.println(last);
        //subString(int start,int end)截取当前字符串中指定范围中的字符串
        String sub=s3.substring(3,8);//范围【3，8）
        String sub1=s3.substring(3);//从三一直到最后
        System.out.println(sub);
        System.out.println(sub1);
        //static xxx类型.valueOf()将其他类型转换为String类型
        int  A=123;
        String  a=String.valueOf(A);
        System.out.println(a);//字符串类型
    }
}
