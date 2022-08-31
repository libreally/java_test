package StaticTest;

public class AccountTest {
    public static void main(String[] args) {
        Account account1=new Account();
        Account account2=new Account("123456",2000);

        System.out.println(account1);
        System.out.println(account2);

        Account.setInterestRate(0.012);//设置利率
        Account.setMinMoney(100);//最低存款余额

        System.out.println(account2.getInterestRate());
        System.out.println(account2.getMinMoney());
    }
}
