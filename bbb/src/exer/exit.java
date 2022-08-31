package exer;

public class exit {
    public static void main(String[] args) {
        String str="abc-defg";
        int index=str.indexOf("-");
        StringBuilder s=new StringBuilder(str);
        StringBuilder s1=s.deleteCharAt(index);//abcdefg
        StringBuilder s2=s1.reverse();//倒叙gfedcba
        StringBuilder result=s2.insert(index,'-');///gfe-dcbd
        System.out.println(result.toString());
    }
}
