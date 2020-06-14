package com.study.java.common;

public class StudyOOP_StudentTest {

    public static void main(String[] args) {

//        StudyOOP_Student stu1=new StudyOOP_Student();
//        StudyOOP_Student stu2=new StudyOOP_Student();
//        StudyOOP_Student stu3=new StudyOOP_Student();
//        StudyOOP_Student stu4=new StudyOOP_Student();
//        StudyOOP_Student stu5=new StudyOOP_Student();


        // 注意：上面的方法太麻烦  放到一个数组里面 统一创建对象加赋值属性
        // ①数组可以放对象
        // ②循环创建 循环赋值

        StudyOOP_Student[]stus=new StudyOOP_Student[20];

        for(int i=0;i<stus.length;i++){
            stus[i]=new StudyOOP_Student();
            stus[i].number=(int)(Math.random()*20)+1;
            stus[i].state=(int)(Math.random()*6)+1;
            stus[i].score=(int)(Math.random()*100);

            if(stus[i].state==3){
                stus[i].studentInfo();
            }
        }

    }
}
