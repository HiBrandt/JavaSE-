package com.project.java.project_02;

/**
 * 管理客户类 处理增删改查客户的逻辑
 */
public class CustomerList {

    //测试main方法
    public static void main(String[] args) {

        CustomerList customerList=new CustomerList(5);
            for (int i=0;i<=4;i++){
                Customer customer=new Customer();
                customerList.addCustomer(customer);
            }
               customerList.deleteCustomer(2);
            Customer customer2=new Customer("BOB",'男',15,"123242342","34443@qq.com");
            customerList.replaceCustomer(3,customer2);
            System.out.println(customerList.getCustomer(3).getAge());
            System.out.println(customerList.getTotal());
            for(int j=0;j<customerList.total;j++){
                System.out.println(customerList.getAllCustomer()[j]);
            }
            customerList.deleteCustomer(10);
            System.out.println(customerList.total);

    }

    //存放Customer对象的数组
    private Customer[] customers;
    // 对象数组的数量
    private int total;

    //构造器 初始化数组 长度为totalCustomer
    public CustomerList(int totalCustomer ){
        //这里注意 已经声明了变量customers了 就不要写成 Customer[]customers=new Customer[totalCustomer];
        //切记切记 这意思是已经声明化好了 只需要初始化
        customers=new Customer[totalCustomer];
    }

    //添加成功返回true;false表示数组已满无法添加 将customer添加到数组的最后一位
    public boolean addCustomer(Customer customer){
            if(total<this.customers.length){
                customers[total]=customer;
                total++;
                return true;
            }else {
                return false;
            }


    }



    //替换 参数为要替换的索引和要替换成为的对象
    public boolean replaceCustomer(int index,Customer customer){
        if(0<=index&& index<customers.length){
            customers[index]=customer;
            return true;
        }else {
            return false;
        }


    }

    //删除
    public boolean deleteCustomer(int index){
        if(0<=index&& index<customers.length){
            customers[index]=null;
            total--;
            return true;
        }else {
            return false;
        }

    }

    //返回所有客户对象
    public Customer[] getAllCustomer(){
        //这里要注意 返回的不是初始化的数组 而是经过增删改查后的
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }
    //返回指定客户信息
    public Customer getCustomer(int index){
        if(0<=index&& index<customers.length){
            return customers[index];
        }
        return null;
    }
    // 获取客户总数
    public int getTotal(){
        return total;
    }

}
