package com.study.java.oop_exer;

import java.util.Scanner;

/**
 *   测试类
 *
 *   定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各
     类雇员对象的引用。利用循环结构遍历数组元素，输出各个对象的类
     型,name,number,birthday。当键盘输入本月月份值时，如果本
     月是某个Employee对象的生日，还要输出增加工资信息
 */
public class PayrollSystem {

    public static void main(String[] args) {

        //虽然不能new Employee的实例，但是可以new Employee类型的数组，存的是子类对象
        Employee [] employee=new Employee[2];

        // ctrl+p 查看参数
        // new 的都是子类对象
        employee[0]=new SalariedEmployee("小明",10001,new MyDate(2020,3,15),10000);
        employee[1]=new HourlyEmployee("小红",10002,new MyDate(1994,10,3),600,8);

        Scanner sc =new Scanner(System.in);
        int month = sc.nextInt();
        for(int i=0;i<employee.length;i++){

            //重写了toString了 直接输出
            System.out.println(employee[i]);
            System.out.println("薪水为:"+employee[i].earnings());
            //或者这样
//            String s = employee[i].toString();
//            System.out.println(s);


            //employee[i] 为子类对象，子类对象可以调用父类的getBirthday()方法
            //Birthday属性又是MyDate类的。MyDate类又有getMonth()的方法。
            if(employee[i].getBirthday().getMonth()==month){
                System.out.println("员工生日奖励100");
            }

        }
    }

}
