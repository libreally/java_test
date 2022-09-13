package StringDemo.exet;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicColorChooserUI;

/**
 * 过去一个字符在字符串中出现的cishu
 * “ab"在”absfhsdkjsudablsdkfhab"中的次数
 */
public class StringTest2 {
    public int getCount(String mainStr,String subStr){
        int mainLength=mainStr.length();
        int subLength=subStr.length();
        int count=0;
        int index;
        if (mainLength>=subLength){
            while ((index=mainStr.indexOf(subStr))!=-1){
                count++;
                mainStr=mainStr.substring(index+subStr.length());
            }
            return count;
        }else {
            return 0;
        }
    }
    @Test
    public void test(){
        String mainStr="absfhsdkjsudablsdkfhab";
        String subStr="ab";
        System.out.println(getCount(mainStr,subStr));
    }
}
