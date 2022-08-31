package regular_expression;

import java.util.Arrays;

public class SplitDemo {
    public static void main(String[] args) {
        String line="abc123def456ghi";
        String[] data=line.split("[0-9]+");//按数字拆分且删除数字
        System.out.println(Arrays.toString(data));//将数组转化为字符串

        line="123.456.789";
        data=line.split("\\.");
        System.out.println(Arrays.toString(data));
    }
}
