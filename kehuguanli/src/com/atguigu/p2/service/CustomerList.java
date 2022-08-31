package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;

/**
 * CustomerList为Customer对象的管理模块，内部用数组管理一组Customer
 * 对象，并提供相应的添加、修改、删除、遍历操作方法供CustomerView调用
 */
public class CustomerList {
    private int total; //记录已保存客户对象的数量
    private Customer[] customers;//用来保存客户对象的数组  Customer是import com.atguigu.p2.bean.Customer包下，需导入

    /**
     * 用来初始化customer数组的构造器
     * @param totalCustomer：用来指定数组的长度
     */
    public CustomerList(int totalCustomer){
        customers=new Customer[totalCustomer];//动态初始化
    }

    /**
     * 添加指定客户到数组中
     * @param customer
     * @return true：添加成功返回true
     */
    public boolean addCustomer(Customer customer){
        if (total>=customers.length){
            return false;
        }
        customers[total]=customer;
        total++;
        //customers[total++]=customer;
        return true;
    }

    /**
     * 修改指定位置上的索引信息
     * @param index：指定位置
     * @param cust：插入信息
     * @return：true 修改成功；false失败
     */
    public boolean replaceCustomer(int index,Customer cust){
         if (index<0||index>=total){
             return false;
         }
         customers[index]=cust;
         return true;
    }

    /**
     * 删除指定客户信息
     * @param index；指定位置
     * @return，成功true，失败false
     */
    public boolean deleteCustomer(int index){
        if(index<0||index>=total){
            return false;
        }
        for (int i=index;i<total-1;i++){
            customers[i]=customers[i+1];//将后面的前移覆盖
        }
        //最后一个置为NULL
        customers[total-1]=null;
        total--;
        //合并63.64    customers[--total]=null;
        return true;
    }

    /**
     * 获取所有客户信息
     * @return
     */
    public Customer[] getAllCustomer(){
        Customer[] custs=new Customer[total];
        for (int i=0;i<total;i++){
            custs[i]=customers[i];//赋值的是地址值
        }
        return custs;
    }

    /**
     * 获取指定索引位置的客户
     * @param index
     * @return:如果找到返回数据，否则返回null
     */
    public Customer getCustomers(int index) {
         if (index<0||index>=total){
             return null;
         }
         return customers[index];
    }

    /**
     * 获取客户数量
     * @return
     */
    public int getTotal(){
        return total;
    }
}
