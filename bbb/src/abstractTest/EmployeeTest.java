package abstractTest;

//抽象类的测试
public class EmployeeTest {
    public static void main(String[] args) {
        Employee manager = new Manager("kuke", 1001, 5000, 50000);
        manager.work();
    }
}
