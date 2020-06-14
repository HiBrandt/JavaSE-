package com.study.java.oop_exer;


/**
 *   定义一个Employee类，该类包含：
     private成员变量name,number,birthday，其中birthday 为MyDate类的对象；
     abstract方法earnings()；
     toString()方法输出对象的name,number和birthday
 */
public abstract class Employee {

    private  String name;
    private  int number;
    private  MyDate birthday;

    public abstract double earnings();


    // 要想new出来的子类也有父类的属性，父类必须定义有参的构造器
    // 子类有责任将参数传递给父类，以便父类初始化
    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", birthday=" + birthday +
                '}';
    }
}
