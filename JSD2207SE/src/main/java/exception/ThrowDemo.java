package exception;

/**
 * 异常的抛出
 * throw关键字允许我们主动对外抛出一个异常,通常下列情况我们会抛出异常:
 * 1:当前代码片段出现了一个异常,但是该异常不应当被当前代码片段处理时(责任制问题)
 * 2:当前程序可以运行但是该运行场景不满足业务需求时(下面的代码就是演示这种情况).
 */
public class ThrowDemo {
    public static void main(String[] args){
        Person p = new Person();
        try {
            /*
                当我们调用一个含有throws声明异常抛出的方法时,编译器要求我们必须
                处理该异常,处理方式有两种:
                1:使用try-catch主动捕获并处理该异常
                2:可以在当前方法上继续使用throws声明该异常的抛出给上层调用者
                具体选取哪种取决于责任制问题.
             */
            p.setAge(1000);//不满足业务场景
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }

        System.out.println("此人年龄:"+p.getAge());
    }
}


