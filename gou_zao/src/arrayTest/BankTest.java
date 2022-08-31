package arrayTest;

public class BankTest {
    public static void main(String[] args) {
        Bank bank=new Bank();
        bank.addCustomer("jane","smith");
        bank.getCustomer(0).setAccount(new Account(2000));
        bank.getCustomer(0).getAccount().withdraw(500);//取钱
        double balance=bank.getCustomer(0).getAccount().getBalance();
        System.out.println("客户"+bank.getCustomer(0).getFirstName()+"余额为"+balance);
    }
}
