package com.study.java.common;

public class StudyOOP_AccountCustomerTest {

    public static void main(String[] args) {
        //初始化Jane Smith
        Customer cu=new Customer("Jane","Smith");
        Account ac=new Account(1000,2000,0.0123);
        cu.setAccount(ac);

        //操作Jane Smith
        ac.withdraw(100);
        ac.withdraw(2000);
        ac.deposit(10000);
        cu.setAccount(ac);
        System.out.println(cu.getFirstNmae()+cu.getLastName()+"的账户id为:"+cu.getAccount().getId()+" 账户余额为:"+cu.getAccount().getBalance()+" 年利率为:"+((cu.getAccount().getAnnualInterestRate())*100)+"%");

    }
}

class Account{
    // 账户id
    private int id;
    //余额
    private double balance;
    //年利率
    private double annualInterestRate;

    //构造器
    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
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

class Customer{
    private String firstNmae;
    private String lastName;
    //账户
    private Account account;

    public Customer(String firstNmae, String lastName) {
        this.firstNmae = firstNmae;
        this.lastName = lastName;
    }

    public String getFirstNmae() {
        return firstNmae;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}



