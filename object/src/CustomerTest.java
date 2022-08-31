//方法：描述类具有的功能

/**
 * 方法的声名： 权限修饰符  返回值类型  方法名（形参列表）{}
 * 1.权限修饰符  private public 缺省  protected
 * 2.返回值类型  1.如果方法有返回值，必须指明返回值类型，同时需要使用return关键字返回指定类型的变量或常量
 *             2.如果没有返回值，类型用void指明即可
 * 3.方法名：见名知意
 */
class Customer{
    //属性==成员变量
    String name="巨画";

    String nation;
    //方法==函数
    //    1.如果没有返回值，类型用void指明即可
    public void eat(){
        System.out.println("吃饭");
    }
    //2.如果方法有返回值，必须指明返回值类型，同时需要使用return关键字返回指定类型的变量或常量
    public String getName(){
        System.out.println(name);
        return  name;
    }
    public String getNation(String nation){
        String info="我的国籍是"+nation;
        System.out.println(nation);
        return nation;
    }

}

public class CustomerTest {
    public static void main(String[] args) {
        Customer cust1 = new Customer();
        cust1.eat();
        cust1.getName();
        cust1.getNation("China");
    }
}
