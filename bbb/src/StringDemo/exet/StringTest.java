package StringDemo.exet;

import org.junit.jupiter.api.Test;

public class StringTest {
    //将一个字符串制定能够位置的翻转比如abcdefg 转换为afedcbg
    //方式一
    public String reverse(String str, int startIndex, int endIndex) {
        if (str != null) {
            char[] arr = str.toCharArray();//字符串转换为字符数组
            for (int x = startIndex, y = endIndex; x < y; x++, y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    //方式二使用string拼接
    public String reverse1(String str, int startIndex, int endIndex) {
        if (str != null) {
            //第一部分不变的
            String reverseStr=str.substring(0,startIndex);
            //第二部分翻转的
            for (int i=endIndex;i>=startIndex;i--){
                reverseStr += str.charAt(i);
            }
            //第三部分不变
            reverseStr +=str.substring(endIndex+1);
            return reverseStr;
        }
        return null;
    }
    //使用StringBuffer
    public String reverse2(String str, int startIndex, int endIndex){
        StringBuilder builder=new StringBuilder(str.length());
        builder.append(str.substring(0,startIndex));
        for (int i=endIndex;i>=startIndex;i--){
            builder.append(str.charAt(i));
        }
        builder.append(str.substring(endIndex+1));
        return builder.toString();
    }

    @Test
    public void testReverse() {
        String str="abcdefg";
        String reverse = reverse(str, 1, 5);
        System.out.println(reverse);
    }
    @Test
    public void testReverse1() {
        String str="abcdefg";
        String reverse = reverse(str, 1, 5);
        System.out.println(reverse);
    }
    @Test
    public void testReverse2() {
        String str="abcdefg";
        String reverse = reverse(str, 1, 5);
        System.out.println(reverse);
    }

}
