package exception;

/**
 * 异常的抛出
 */
public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalAgeException {
        if(age<0||age>100){
            //throw将异常实例抛出到setAge方法之外,由调用该方法的代码片段去处理
//            throw new RuntimeException("年龄不合法");
            /*
                除了RuntimeException之外的其他异常如果要抛出就必须在方法上
                使用throws声明该异常的抛出来通知调用者处理这个异常
             */
            throw new IllegalAgeException("年龄不合法");
        }
        this.age = age;
    }
}
