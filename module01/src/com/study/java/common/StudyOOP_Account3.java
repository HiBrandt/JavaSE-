package com.study.java.common;

public class StudyOOP_Account3 {

    private int id;

    //子类重写的方法需要调用该属性 所以不能为private
    protected double balance;
    private double annualInterestRate;

    //构造器


    public StudyOOP_Account3(int id, double balance, double annualInterestRate) {
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

    //取款
    public void withdraw (double amount){
        if(amount>balance){
            System.out.println("余额不足您的账户余额为:"+balance+"元。");
        }else {
            System.out.println("取款成功，您的账户余额为:"+(balance-=amount)+"元。");
        }

    }
    //存款
    public void deposit (double amount){
        System.out.println("您本次存入"+amount+"元,账户余额为:"+(amount+=balance)+"元。月利率为:"+annualInterestRate);

    }
}

class CheckAccount extends StudyOOP_Account3{

    //可以透支的额度
    private double overdraft;

    //强制必须写父类的构造器 然后再加上自己独有的属性
    //那么如果一个子类继承了一个父类，父类具有参数构造函数，那么子类有责任将参数传递给父类，以便父类初始化。
    public CheckAccount(int id, double balance, double annualInterestRate,double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft=overdraft;
    }

    @Override
    public void withdraw(double amount) {

        if(amount<=this.balance){
            System.out.println("取款成功，您的账户余额为:"+(balance-=amount)+"元。");
        }else {
            if(overdraft>amount){
                System.out.println("取款成功，您的账户余额为:0 元"+"剩余可透支余额为"+(balance-amount+overdraft)+"元。");
            }else {
                System.out.println("余额不足，无法取出");
            }
        }
    }
}

class Test{

    public static void main(String[] args) {

        StudyOOP_Account3 account=new StudyOOP_Account3(1122,20000,0.045);
        account.withdraw(30000);
        account.withdraw(2500);
        account.deposit(3000);

        CheckAccount checkAccount=new CheckAccount(1122,20000,0.045,5000);
        checkAccount.withdraw(5000);
        checkAccount.withdraw(18000);
        checkAccount.withdraw(3000);


    }
}
