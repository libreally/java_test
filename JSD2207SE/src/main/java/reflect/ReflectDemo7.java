package reflect;

public class ReflectDemo7 {
    public static void main(String[] args) throws Exception {
        Class cls=Class.forName("reflect.Person");
        //判断当钱cls是否被注解标注
        if (cls.isAnnotationPresent(AutoCloseable.class)){
            System.out.println("被标注");
        }else {
            System.out.println("NO!");
        }

    }
}
