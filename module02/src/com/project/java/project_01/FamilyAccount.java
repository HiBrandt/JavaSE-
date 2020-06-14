package com.project.java.project_01;

/**
 * 家庭记账软件
 * details变量的使用  可以记录收支明细 很神奇 +=的应用
 * while循环的灵活使用
 */

public class FamilyAccount {

    public static void main(String[] args) {
        showHome();
    }

    // 主界面的方法
    public static void showHome(){

        boolean flag = true;
        // 存储收支明细的变量
        String details = "";
        //账户初始变量
        int amount = 10000;
        while (flag){

            System.out.println("-------家庭收支记账软件---------");
            System.out.println("1 收支明细");
            System.out.println("2 登记收入");
            System.out.println("3 登记支出");
            System.out.println("4 退    出");
            System.out.println("请选择1--4");
            // 调用 Utility 读取键盘1---4的方法 返回char
            char selection = Utility.readMenuSelection();

            switch (selection){
                case '1':
                    System.out.println("1.收支明细");
                    System.out.println("-------------当前收支明细记录-------------");
                    System.out.print("收支");
                    System.out.print("       账户金额");
                    System.out.print("       收支金额");
                    System.out.println("       说明");
                    // 输出变量 details
                    System.out.println(details);
                    System.out.println("----------------------------------");
                    break;
                case '2':
                    System.out.println("2.登记收入");
                    System.out.print("请输入收入金额 :");
                    int inCome = Utility.readNumber();
                    System.out.print("请输入收入说明 :");
                    String inExplain = Utility.readString();
                    amount+=inCome;
                    details +=("收入       "+amount+"         "+inCome+"          "+inExplain+"\n");
                    break;
                case '3':
                    System.out.println("3.登记支出");
                    System.out.println("请输入支出金额 :");
                    int pay = Utility.readNumber();
                    System.out.print("请输入支出说明 :");
                    String outExplain = Utility.readString();
                    amount-=pay;
                    details +=("支出       "+amount+"          "+pay+"          "+outExplain+"\n");
                    break;
                case '4':
                    System.out.println("确认是否退出<Y/N> ?");
                    char isExit = Utility.readConfirmSelection();
                    if(isExit=='Y'){
                        flag=false;
                    }

            }
        }
    }
}
