package com.study.java.common;

public class StudyOOP_Person {
    String name;
    int age;
    boolean sex;

    public void study(){
        System.out.println("studying....");
    }

    public int showAge(int age){
        this.age=age;
        return age;
    }

    public int addAge(){
        return age+2;
    }

}
