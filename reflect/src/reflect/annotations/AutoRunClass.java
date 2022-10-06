package reflect.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解 JDK8之后引入的一个新特性。我们可以利用注解辅助反射机制。
 * 注解使用前需要先定义。
 *
 * JAVA有几个内置的注解是用来为我们自定义的注解添加某些特性的
 * @Target注解:用于说明我们定义的注解可以被应用在哪些位置。
 *            注解允许的值都被定义在ElementType上。
 *            常见的有:
 *            ElementType.TYPE 类上
 *            ElementType.Method 方法上
 *            ElementType.Field 属性上
 *            等等
 * @Retention注解:用于说明当前注解的保留级别，有三个可选值:
 *          RetentionPolicy.SOURCE  注解仅保留在源码文件中
 *          RetentionPolicy.CLASS   注解会被保留在字节码文件中，但是不可被反射机制访问。这些也是注解的默认保留级别
 *          RetentionPolicy.RUNTIME 注解会被保留在字节码文件中且可以被反射机制访问。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoRunClass {
}
