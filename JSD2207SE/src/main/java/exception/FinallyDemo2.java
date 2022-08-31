package exception;

/**
 * 与finally相关的面试题
 * 1:分别说明final,finally,finalize是什么?
 *   finalize是Object定义的一个方法，该方法是一个对象生命周期中最后一个方法。被GC调用
 *   当GC发现一个对象没有引用后，就会将其释放，释放前最后调用的方法就是finalize.
 *
 * 2:下面的代码
 */
public class FinallyDemo2 {
    public static void main(String[] args) {
        System.out.println(
                test("0")+","+test(null)+","+test("")
        );//3,3,3
    }
    public static int test(String str){
        try {
            return str.charAt(0)-'0';
        } catch (NullPointerException e) {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;//finally中通常不应当有return，否则一定返回这个值。
        }
    }
}







