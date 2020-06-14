package com.project.java.project_03.teamviewdomain;

/**
 * 员工类
 * 公司各种所有员工的父类
 */
public class Employee {


    private int id; //编号
    private String name; //姓名
    private int age; //年龄
    private double salary;//薪水


    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //为子类的toString服务的  因为每个子类都要重写toString ，而name age salary又是公共的
    //所以就抽出来作为一个方法
    //protected不同包下的子类可以调用
    protected String getDetails() {
        return id + "\t" + name + "\t" + age+ "\t" +salary;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
