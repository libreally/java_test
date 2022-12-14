package exer;

/**
 * 银行账户问题
 * 有两个储户分别向同一个账户存储3000元每次1000，存3次，每次存完打印账户余额
 * 分析：
 * 1.是否有多线程问题？是，两个储户线程
 * 2.是否有数据共享？ 是，账户共享
 * 3.是否有线程安全问题：有，只要有共享数据就可能产生
 * 4.如何解决线程安全问题？采取同步机制 三种方式 synchronized ,lock,同步方法
 */

class Account{
    private double balance;
    public Account(double balance) {
        this.balance = balance;
    }
    //存钱
    public  void deposit(double amt){
        if (amt>0){
            synchronized(this){
                balance+=amt;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"存钱成功,余额为："+balance);
            }
        }
    }
}
class Customer extends Thread{
    private Account acct;
    public Customer(Account acct){
        this.acct=acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }

    }
}
public  class AccountTest {
    public static void main(String[] args) {
        Account acct=new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();;
        c2.start();
    }

}
