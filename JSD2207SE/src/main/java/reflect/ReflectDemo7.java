package reflect;

import reflect.annotations.AutoRunClass;

/**
 * 反射机制中操作注解
 */
public class ReflectDemo7 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        //判断当前cls(表示的Person类)所表示的类是否被注解@AutoRunClass标注
        if(cls.isAnnotationPresent(AutoRunClass.class)){
            System.out.println("被标注了!");
        }else{
            System.out.println("没有被标注!");
        }

    }
}
