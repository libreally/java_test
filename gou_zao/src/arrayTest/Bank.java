package arrayTest;

import com.sun.jdi.request.BreakpointRequest;

import java.util.concurrent.Callable;

public class Bank {
    private Customer[] customers;//存放客户
    private int numberOfCustomers;//客户个数
    public Bank(){
        customers=new Customer[10];
    }
    //添加客户
    public void addCustomer(String f,String l){
        Customer cust=new Customer(f,l);
        //customers[numberOfCustomers++]=cust;
        customers[numberOfCustomers]=cust;
        numberOfCustomers++;
    }
    //获取客户个数
    public int getNumberDfCustomer(){
        return numberOfCustomers;
    }
    //获取客户指定位置上的客户
    public Customer getCustomer(int index){
        //return customers[index];空指针或者角标越界
        if (index>=0&&index<numberOfCustomers){
            return customers[index];
        }else
            return null;
    }
}
