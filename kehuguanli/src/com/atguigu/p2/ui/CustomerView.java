package com.atguigu.p2.ui;
/**
 * 显示用户处理操作
 */
import com.atguigu.p2.bean.Customer;
import com.atguigu.p2.service.CustomerList;
import com.atguigu.p2.util.CMUtility;

public class CustomerView {
    //最大用户数量10个
    private CustomerList customerList=new CustomerList(10);
    public CustomerView(){
        Customer customer = new Customer("张三",'男',30,"010-25451484","11561354@qq.com");
        customerList.addCustomer(customer);
    }
    //显示客户信息管理软件页面
    public void enterMainMenu(){
        boolean isFlag=true;
        while (isFlag){
            System.out.println("--------------------信息客户管理软件--------------------");
            System.out.println("                       1 添加客户");
            System.out.println("                       2 修改客户");
            System.out.println("                       3 删除客户");
            System.out.println("                       4 客户列表");
            System.out.println("                       5 退   出\n");
            System.out.print("      请选择(1-5):");
            char menu= CMUtility.readMenuSelection();//选择1-5
            switch (menu){
                case '1':
                    addNewCustomer();break;
                case '2':
                    modifyCustomer();break;
                case '3':
                    deleteCustomer();break;
                case '4':
                    listAllCustomers();break;
                case '5':
                    System.out.println("确认是否退出(Y/N):");
                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit=='Y'){
                        isFlag=false;
                   }
            }

        }
    }
    //添加客户
    private void addNewCustomer(){
        System.out.println("--------------------添加客户--------------------");
        System.out.print("姓名:");
        String  name=CMUtility.readString(10);
        System.out.print("性别:");
        char gender=CMUtility.readCher();
        System.out.print("年龄:");
        int age=CMUtility.readInt();
        System.out.print("电话:");
        String phone=CMUtility.readString(13);
        System.out.print("邮箱:");
        String email=CMUtility.readString(30);
        //将以上数据封装到对象
        Customer customer=new Customer(name,gender,age,phone,email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess) {
            System.out.println("--------------------添加完成--------------------");
        }   else
        {
            System.out.println("--------------------客户已满，添加失败--------------------");
        }
    }
    //修改客户
    private void modifyCustomer(){
        System.out.println("--------------------修改客户--------------------");
        Customer cust;
        int number;
        for (;;){
            System.out.print("请选择待修改客户编号(-1退出)：");
            number= CMUtility.readInt();
            if (number==-1){
                return;
            }
            cust=customerList.getCustomers(number-1);
            if (cust==null){
                System.out.println("无法找到指定客户");
            }
            else {
                break;
            }
        }
        //修改信息
        System.out.print("姓名("+cust.getName()+"):");
        String name=CMUtility.readSting(10,cust.getName());
        System.out.print("性别("+cust.getGender()+"):");
        char gender=CMUtility.readChar(cust.getGender());
        System.out.print("年龄("+cust.getAge()+"):");
        int age=CMUtility.readInt(cust.getAge());
        System.out.print("电话("+cust.getPhone()+"):");
        String phone=CMUtility.readSting(13,cust.getPhone());
        System.out.print("邮箱("+cust.getEmail()+"):");
        String email=CMUtility.readSting(30,cust.getEmail());
        //
        Customer newcust=new Customer(name,gender,age,phone,email);
        boolean isReaplaced= customerList.replaceCustomer(number-1,newcust);
        if (isReaplaced){
            System.out.println("--------------------修改客户--------------------");
        }else
            System.out.println("--------------------修改失败--------------------");
    }
    //删除客户
    private void deleteCustomer(){
        System.out.println("--------------------删除客户--------------------");
        int number;
        for (;;){
            System.out.print("请选择待修改客户编号(-1退出)：");
            number=CMUtility.readInt();
            if(number==-1){
                return;
            }
            Customer customer=customerList.getCustomers(number-1);
            if (customer==null){
                System.out.println("找不到客户！");
            }
            else{
                break;
            }
        }
        //找到了客户，进行删除
        System.out.print("确认删除(Y/N):");
        char isDelete=CMUtility.readConfirmSelection();
        if (isDelete == 'Y') {
            boolean deleteSuccess=customerList.deleteCustomer(number-1);
            if (deleteSuccess){
                System.out.println("--------------------删除成功--------------------");
            }else {
                System.out.println("--------------------删除失败--------------------");
            }
        }else
            return;
    }
    //显示客户列表
    private  void listAllCustomers(){
        System.out.println("--------------------客户列表--------------------\n");
        int total=customerList.getTotal();
        if(total==0){
            System.out.println("没有客户记录！");
        }
        else{
            System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t\t电话\t\t\t\t\t邮箱");
            Customer[] custs=customerList.getAllCustomer();
            for (int i=0;i<custs.length;i++){
                Customer cust = custs[i];
                System.out.println((i+1)+"\t\t"+cust.getName()+"\t\t"+cust.getGender()+"\t\t"+
                                              cust.getAge()+"\t\t\t"+cust.getPhone()+"\t\t"+
                                               cust.getEmail());
            }
        }
        System.out.println("------------------客户列表完成-------------------");
    }

    public static void main(String[] args) {
        CustomerView view=new CustomerView();
        view.enterMainMenu();
    }
}
