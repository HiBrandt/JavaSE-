package com.study.java.common;

public class StudyOOP_AccountCustomerTest2 {

    public static void main(String[] args) {

        Bank bank=new Bank();
        bank.addCustomer2("Jane","Smith");
        bank.getCustomer(0).setAccount(new Account2(2000));
        bank.getCustomer(0).getAccount().withdraw(200);
        Account2 account = bank.getCustomer(0).getAccount();
        System.out.println(account);

    }
}
class Account2{

    private double balance;

    public Account2(double balance){
        this.balance=balance;
    }

    public double getBalance() {
        return balance;
    }

    //取钱
    public void withdraw(double amount){
        if(amount>balance){
            System.out.println("取钱失败余额不足");
        }else{
            this.balance=balance-amount;
            System.out.println("取出:"+amount+"元,余额为:"+(balance)+"元");
        }

    }
    //存钱
    public void deposit(double amount){
        this.balance=balance+amount;
        System.out.println("存入:"+amount+"元,余额为:"+(balance)+"元");
    }
}

class Customer2{
    private String firstNmae;
    private String lastName;
    //账户属性
    private Account2 account;

    public Customer2(String firstNmae, String lastName) {
        this.firstNmae = firstNmae;
        this.lastName = lastName;
    }

    public String getFirstNmae() {
        return firstNmae;
    }

    public String getLastName() {
        return lastName;
    }

    public Account2 getAccount() {
        return account;
    }

    public void setAccount(Account2 account) {
        this.account = account;
    }
}

class Bank{
    //Customer2类型的数组来存储客户
    private Customer2[] customers;
    private int numberOfCustomer;

    public Bank() {
        // 调用构造器 初始化一个数组
        customers = new Customer2[10];

    }

    public Customer2[] getCustomers() {
        return customers;
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }

    // 添加Customer2
    public void addCustomer2(String f,String l){
        Customer2 cu=new Customer2(f,l);
         this.customers[numberOfCustomer]=cu;
        numberOfCustomer++;
    }
    //获取指定索引的客户信息
    public Customer2 getCustomer(int index){
        if(index>=0 && index<customers.length){
            return customers[index];
        }
        return null;

    }


}
