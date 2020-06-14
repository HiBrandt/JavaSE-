package com.study.java.helloworld;

import java.util.Scanner;

public class HelloWorld_1 {

    public static void main (String[]args){
   /*     // Hello World
        System.out.println("Hello World ");

        // ++先运算 再进行==
        int x = 1;
        int y = 1;
        if(x++==2|++y==2){
            x=7;
        }
        System.out.println("x="+x);

        // 三元运算符找最大值 记得有括号
        int a = 3;
        int b = 4;
        int c = (a>b)?a:b;
        System.out.println("c="+c);

        int d = 5;
        int e = 6;
        int f = 7;
        int max1 = (d>e)?d:e;
        int max2 = (max1>f)?max1:f;

        System.out.println("max2="+max2);

        //计算+2的操作 用 int num += 2;(不改变数据类型) 计算+1的操作 用 num++;
        int num=d += 2;
        num++;
        System.out.println("num="+num);*/

       // TestScanner();
        TestIF();
    }
    public static void TestScanner(){

        System.out.println("请输入你的考试分数:");
        Scanner scanner=new Scanner(System.in);
        int score=scanner.nextInt();
        if(score==100){
            System.out.println("奖励一台BMW");
        }else if(score>80 && score<=90){
            System.out.println("奖励一台iphone");
        }else if(score>=60 && score<80){
            System.out.println("奖励一台ipad");
        }else {
            System.out.println("没有奖励");
        }

        System.out.println("请输入三个数字我们要拿到最大值:");
        int i1 = scanner.nextInt();
        int i2 = scanner.nextInt();
        int i3 = scanner.nextInt();
        // 找到最大值
        if(i1>i2){
            if(i1>i3){
                System.out.println("您输入的最大值为:"+i1);
            }else{
                System.out.println("您输入的最大值为:"+i3);
            }

        }else if(i2>i3) {
            System.out.println("您输入的最大值为:"+i2);
        }else {
            System.out.println("您输入的最大值为:"+i3);
        }

        //排序
        if(i1>i2 && i2>i3){
            System.out.println("三个数字由大到小为:"+i1+" "+i2+" "+i3);
        }else if(i1>i2 && i2<i3){
            System.out.println("三个数字由大到小为:"+i1+" "+i3+" "+i2);
        }else if(i1<i2 && i2<i3){
            System.out.println("三个数字由大到小为:"+i3+" "+i2+" "+i1);
        }else if(i2<i1 && i1<i3){
            System.out.println("三个数字由大到小为:"+i3+" "+i1+" "+i3);
        }else if(i1<i3 && i3<i2){
            System.out.println("三个数字由大到小为:"+i2+" "+i3+" "+i1);
        }else{
            System.out.println("三个数字由大到小为:"+i2+" "+i1+" "+i3);
        }
    }

    public static  void  TestIF(){

        // 判断狗的年龄
//        System.out.println("请输入狗狗的年龄:");
//        Scanner sc=new Scanner(System.in);
//        int d_age = sc.nextInt();  //狗的年龄
//        double p_age;  //人的年龄
//        if(d_age<=0){
//            System.out.println("您输入的年龄不合法，请重新输入:");
//        }else if(d_age<=2 && d_age>0) {
//            p_age = 10.5*d_age;
//            System.out.println("狗狗的年龄为:"+p_age);
//        }else{
//            p_age = 10.5*2+(d_age-2)*4;
//            System.out.println("狗狗的年龄为:"+p_age);
//        }

        // 彩票
        System.out.println("请输入您的两个幸运数字:");
       // int random =(int) (Math.random()*100) ;
       // int random2 =(int) (Math.random()*100) ;

        int random=10;
        int random2=11;
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a==random && b==random2){
            System.out.println("奖励10000");
        }else if(a==random2 && b==random){
            System.out.println("奖励3000");
        }else if((a==random && b!=random2) || (b==random2 &&a!=random)){
            System.out.println("奖励1000");
        }else if((a==random2 && b!=random) || (b==random && a!=random2)){
            System.out.println("奖励500");
        }else{
            System.out.println("没有奖励");
        }

        System.out.println("中奖数字为:"+random+" "+random2);
    }

}
