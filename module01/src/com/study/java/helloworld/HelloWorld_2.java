package com.study.java.helloworld;

import java.util.Scanner;

public class HelloWorld_2 {

    public static void main(String[] args) {

        //testSwitchcase();
        testCycle();
    }
    public static void testSwitchcase(){

        //switch case 括号里面通常是一个类型的变量(int short string 枚举) 注意不是条件表达式
        // case 的值 必须是常量 不能是不确定的
        // 匹配到之后不会像if else 跳出 而是继续向下执行，且一定执行
        // 如果要控制跳出的话，可以用关键字 如：break
        // default 是兜底的 类似于else，可以不加break
        int num=2;
        switch (num){

            case 1:
                System.out.println("1");
                    //break;
            case 2:
                System.out.println("2");
                    break;
            case 3:
                System.out.println("3");
                    break;
            default:
                System.out.println("other");
        }


        //使用 switch 把小写类型的 char型转为大写。只转换 a, b, c, d, e. 其它的输出 “other”
            String str="a";
            char c = str.charAt(0);

            switch (c){
                case 'a':
                    System.out.println("A");
                        break;
                case 'b':
                    System.out.println("B");
                        break;
                case 'c':
                    System.out.println("C");
                        break;
                case 'd':
                    System.out.println("D");
                        break;
                default:
                    System.out.println("other");
            }

        // 从键盘分别输入年、月、日，判断这一天是当年的第几天
        // 利用switch case 的break属性 进行倒着算 绝妙
            System.out.println("请输入 年、月、日:");
            Scanner sc=new Scanner(System.in);
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            // 累加计数器
            int sum = 0;
            if(month<1 || month>12 || day<1 || day>31){
                System.out.println("您输入的数据格式不合法");
            }else{
                if((year%4==0 && year%100!=0) || year%400==0){
                    switch (month){
                        case 12:
                            sum+=31;
                        case 11:
                            sum+=30;
                        case 10:
                            sum+=31;
                        case 9:
                            sum+=30;
                        case 8:
                            sum+=31;
                        case 7:
                            sum+=31;
                        case 6:
                            sum+=30;
                        case 5:
                            sum+=31;
                        case 4:
                            sum+=30;
                        case 3:
                            sum+=31;
                        case 2:
                            sum+=29;
                        case 1:
                            System.out.println("一年的第"+(sum+=day)+"天");
                    }

                }else{
                    switch (month){
                        case 12:
                            sum+=31;
                        case 11:
                            sum+=30;
                        case 10:
                            sum+=31;
                        case 9:
                            sum+=30;
                        case 8:
                            sum+=31;
                        case 7:
                            sum+=31;
                        case 6:
                            sum+=30;
                        case 5:
                            sum+=31;
                        case 4:
                            sum+=30;
                        case 3:
                            sum+=31;
                        case 2:
                            sum+=28;
                        case 1:
                            System.out.println("一年的第"+(sum+=day)+"天");
                    }
                }
            }


    }

    public static void testCycle(){

        // 体会换行符
        // 以及同时为 3的倍数 和 5的倍数 以及7的倍数的情况 所以不能用else if
        for(int i=1; i<=150;i++){
            System.out.print(i);

            if(i%3==0){
                System.out.print(" foo");
            }
            if(i%5==0){
                System.out.print(" biz");
            }
            if(i%7==0){
                System.out.print(" baz");
            }
            System.out.println();


        }
        // 打印1~100之间所有是7的倍数的整数的个数及总和（体会设置计数器的思想)
        int count =0;
        int sum=0;
        for(int i=1; i<=100;i++){
            if(i%7==0){
                count++;
                sum+=i;    //如果步长是1就是++，现在步长不是1 就用 +=
            }
        }
        System.out.println("7的倍数的个数是:"+count+"个,7的倍数的总和是:"+sum);

        // 输入两个正整数m和n，求其最大公约数和最小公倍数
        // 思路：在求最大公约数时 先找到公约数的范围 肯定是 大于等于1 小于等于 m和n之间的最小数
        // 找最大从右向左数，找最小从左往右数
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一个数:");
        int m = sc.nextInt();
        System.out.println("请输入第二个数:");
        int n = sc.nextInt();
        //最大公约数
        //找到 m和n之间的最小数
        int min=(m>n)?n:m;
        //倒序排序，目的是为了从后向前找 方便找到最大的。
        for(int i=min; i>=1; i--){
            if(m%i==0 && n%i==0){
                System.out.println("最大公约数为:"+i);
                //找到最大的就跳出循环，不然就会把公约数全部输出
                // break 在if中也会跳出循环
                break;
            }
        }
        //最小公倍数
        int max=(m>n)?m:n;
        for(int j=max;j<=m*n;j++){
            if(j%n==0 && j%m==0){
                System.out.println("最小公倍数为:"+j);
                //跳出 别忘了
                break;
            }
        }

        //while 循环的初始化参数可以跨出循环，作用范围不同
        //从键盘读入个数不确定的整数，并判断读入的正数和负数的个数，输入为0时结束程序
        int nextInt;
        boolean flag=true;
        //计数器
        int x=0;
        int y=0;
        while (flag){
            nextInt = sc.nextInt();
            if(nextInt%2==0){
                x++;
            }else {
                y++;
            }
            if(nextInt==0){
                flag=false;
            }

        }

        System.out.println("奇数的个数为:"+y+" 偶数的个数为:"+x);

        // 九九乘法表
        for(int a=1;a<=9;a++){   //行数
            for(int b=1; b<=a; b++){ //列数
                System.out.print(a+"*"+b+"="+(a*b)+"  ");
            }
            System.out.println();
        }
        // break 终止循环  continue 终止当前一次循环  return终止方法

    }
}
