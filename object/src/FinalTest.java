/**
 * final
 * 1.修饰的结构 类 方法 变量
 * 2.修饰类 不可被其他类继承
 * 3.修饰方法 不可被重写
 * 4.修饰变量 不可被改变 成为常量
 *   修饰属性：可赋值位置：显示初始化/代码块中 /构造器中
 *   修饰局部变量： 方法体里面则会成为常量 形参时表明形参时一个常量
 *               当调用方法是，给常量形参付一个实参，一旦赋值以后
 *               就不可以被改变，只能在方法体中使用
 */
public class FinalTest {

}

final class FinalA{
    public void show(final int dd){

        final  int WW = 1;

    }
}
class B {}

