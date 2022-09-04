package java;

/**
 * 使用同步机制将单例模式中的懒汉式转为线程安全的
 */
public class BankTest {

}
class Bank{
    private Bank(){}
    private static Bank instance=null;

   /* public static synchronized Bank getInstance() {
            if (instance == null) {
                instance = new Bank();
            }
        return instance;
    }*/
   public static Bank getInstance() {
       if (instance == null){
           synchronized (Bank.class) {
               if (instance == null) {

                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   instance = new Bank();
               }
           }
       }
       return instance;
   }
}