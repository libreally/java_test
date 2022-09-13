package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计字符串中每个字符出现的次数
 * 思路:
 * 用一个Map保存统计结果，key保存出现的字符，value保存该字符出现的次数
 * 利用字符串的charAt方法可以遍历字符串中每一个字符
 * 如果map中该字符不存在，则存入，并且对应的次数为1
 * 如果map中该字符已经存在，则根据该字符作为key提取其value(出现的次数)并对value+1再
 * 存回。
 * 遍历有输出map即可得知每个字符出现的次数。
 */
public class MapDemo3 {
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        String str = "Thinking in java!i love java!";
        count(str);
        count1(str);
    }

    public static void count1(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int num = map.containsKey(c) ? map.get(c) + 1 : 1;
            map.put(c,num);
            /*if (map.containsKey(c)){
                int sum=map.get(c);
                sum+=1;
                map.put(c,sum);
            }else {
                map.put(c,1);
            }*/
        }
        System.out.println(map);
    }

    public static void count(String str) {
        //将字符串转化为字符数组
        char[] chars = str.toCharArray();
        //创建一个HashMap名为hm
        HashMap<Character, Integer> hm = new HashMap();
        //定义一个字符串c，循环遍历遍历chars数组
        for (char c : chars) {
            //containsKey(c),当c不存在于hm中
            if (!hm.containsKey(c)) {
                hm.put(c, 1);
            } else {
                //否则获得c的值并且加1
                hm.put(c, hm.get(c) + 1);
            }
            //或者上面的if和else替换成下面这一行
            hm.put(c, hm.containsKey(c) ? hm.get(c) + 1 : 1);
        }
        for (Character key : hm.keySet()) {
            //hm.keySet()代表所有键的集合,进行格式化输出
            System.out.println(key + "====" + hm.get(key));
        }
    }
}
