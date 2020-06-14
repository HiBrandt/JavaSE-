package com.study.java.common;

/**
 *  定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩
    score(int)。 创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
    问题一：打印出3年级(state值为3）的学生信息。
    问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
 */

public class StudyOOP_Student {
    int number;
    int state;
    int score;

    public void studentInfo(){
        System.out.println("学号为:"+number+",年级为:"+state+",成绩为:"+score);
    }

}
