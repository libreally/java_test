package com.atguigu.p2.util;
import java.util.*;

/**
 * CMUtility工具类将不同的功能封装为方法，就是可以通过直接调用使用他的功能，无需考虑他的实现细节
 */
public class CMUtility {
    private static Scanner scanner=new Scanner(System.in);
    /**
     * 用于界面菜单的选择，该方法读取键盘如果用户键入1-5中的任意字符，怎方法返回，返回值为用户键入字符
     */
    public static char readMenuSelection(){
        char c;
        for(;;){
            String str=readKeyBoard(1,false);
            c=str.charAt(0);
            if (c!='1'&&c!='2'&& c!='3'&&c!='4'&&c!='5'){
                System.out.println("选择错误，请重新输入");
            } else break;
        }
        return c;
    }
    /**
     * 从键盘读取一个字符，并将其作为方法的返回值
     */
    public static char readCher(){
        String str = readKeyBoard(1,false);
        return str.charAt(0);
    }
    /**
     * 从键盘读取一个字符并将其作为方法的返回值
     * 如果用户不输入字符而且直接回车，方法将以defaultValue作为返回值
     */
    public static char readChar(char defaultValue){
        String str = readKeyBoard(1,true);
        return (str.length()==0)?defaultValue:str.charAt(0);
    }
    /**
     * 从键盘读取一个长度不超过2位的证书，并将其作为返回值
     */
    public static int readInt(){
        int n;
        for (;;){
            String str = readKeyBoard(2,false);
            try{
                n=Integer.parseInt(str);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("数字输入错误，请重新输入");
            }
        }
        return n;
    }
    /**
     * 从键盘读取一个长度不超过2位的整书，并将其作为返回值
     * 如果用户不输入字符而且直接回车，方法将以defaultValue作为返回值
     */
    public static int readInt(int defaultValue){
        int n;
        for (;;){
            String str = readKeyBoard(2,false);
            if (str.equals("")){
                return defaultValue;
            }
            try{
                n=Integer.parseInt(str);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("数字输入错误，请重新输入");
            }
        }
        return n;
    }
    /**
     * 从键盘读取一个长度不超过limit位的字符串，并将其作为方法返回值
     */
    public static String readString(int limit){
        return readKeyBoard(limit,false);
    }
    /**
     * 从键盘读取一个长度不超过limit位的字符串，并将其作为方法返回值
     * 如果用户不输入字符串而且直接回车，方法将以defaultValue作为返回值
     */
    public static String readSting(int limit ,String defaultValue){
        String str=readKeyBoard(limit,true);
        return str.equals("")?defaultValue:str;
    }
    /**
     * 用于确认选择的输入，该方法从键盘读取Y\N，并将其作为方法的返回值
     */
    public static char readConfirmSelection(){
        char c;
        for (;;){
            String str = readKeyBoard(1,false).toUpperCase();
            c=str.charAt(0);
            if (c=='Y'||c=='N'){
                break;
            }
            else
                System.out.println("选择错误，请重新输入");
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line="";
        while(scanner.hasNextLine()){
            line=scanner.nextLine();
            if (line.length()==0){
                if (blankReturn) return line;
                else continue;
            }
            if (line.length()<1||line.length()>limit){
                System.out.println("输入长度（不大于"+limit+")错误，请重新输入");
                continue;
            }
            break;
        }
        return line;
    }

}
