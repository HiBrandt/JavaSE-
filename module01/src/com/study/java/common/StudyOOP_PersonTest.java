package com.study.java.common;

public class StudyOOP_PersonTest {

    public static void main(String[] args) {

        StudyOOP_Person p1=new StudyOOP_Person();
        p1.study();

        int age = p1.showAge(7);
        System.out.println(age);

        int Addage = p1.addAge();
        System.out.println(Addage);
    }
}
