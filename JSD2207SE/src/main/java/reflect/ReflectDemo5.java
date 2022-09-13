package reflect;

import java.lang.reflect.Method;

/**
 * 调用有参数方法
 */
public class ReflectDemo5 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.say("大家好!");
        p.say("我真的栓Q",5);

        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();
        //say(String)
        Method method = cls.getMethod("say",String.class);
        method.invoke(obj,"大家好!");
        //say(String,int)
        Method method2 = cls.getMethod("say",String.class,int.class);
        method2.invoke(obj,"我真的栓Q",10);
    }
}





