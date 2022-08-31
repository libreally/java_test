package regular_expression;

/**
 * matches(String regex)
 * 使用给定的正则表达式（regex）验证当前字符串的格式是否符合要求
 */
public class MatchesDemo {
    public static void main(String[] args) {
        /*邮箱的正则表达式
          [a-zA-Z0-9_]+@[a-zA-Z0-9]+(\.[a-zA-Z]+)+
        * */
        String email ="wang@tedu.cn";
        String regex="[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
        boolean matches = email.matches(regex);
        if (matches){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
