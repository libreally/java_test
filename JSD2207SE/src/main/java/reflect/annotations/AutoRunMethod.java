package reflect.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoRunMethod {
    /*
        注解中可以添加参数，格式为:
        参数类型 参数名() [default 默认值]
        default可以为参数设定默认值，当使用注解不传递参数时则采取默认值。

        当注解只有一个参数时，参数名建议选取"value",这样在使用注解时便于传递参数。
        例如:@AutoRunMethod(22)

        正常使用注解时，参数传递的格式为:@AutoRunMethod(value=22).即:参数名=参数值。
        参数的顺序可以与定义时不一致。
     */
    int value() default  1;

    /*
        多个参数时，传参顺序不讲究:
         @AutoRunMethod(name="world",num=6)
         @AutoRunMethod(num=6,name="world")
     */
   /* int value() default  1;
    String name() default "abc";*/
}
