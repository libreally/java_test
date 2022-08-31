package regular_expression;

/**
 * String replaceAll(String regex,String s)替换
 * 将字符串中满足正则表达式regex的部分替换为给定的字符串S
 */
public class ReplaceAllDemo {
    public static void main(String[] args) {
        String email ="wang@tedu.cn";
        System.out.println("初始化："+email);
        String regex="[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
        String replaceAll = email.replaceAll(regex, "liberally@gmail.com");
        System.out.println("替换后得到：" + replaceAll);


        String line="123asf124sfsegdh34";
        String hhh = line.replaceAll("[0-9]+", "#HHH#");
        System.out.println(hhh);
    }
}
