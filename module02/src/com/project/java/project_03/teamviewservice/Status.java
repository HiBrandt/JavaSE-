package com.project.java.project_03.teamviewservice;

/**
 * 描述工作状态
 * 枚举的味道
 * 三个对象
 */
public class Status {

    private String status;

    //对象固定只有三种 所以要私有化构造器
    private Status(String status) {
        this.status = status;
    }

    public static final Status FREE=new Status("FREE"); //空闲

    public static final Status BUSY=new Status("BUSY");  //忙碌

    public static final Status VOCATION=new Status("VOCATION"); //休假


    @Override
    public String toString() {
        return status + '\t';

    }


}
