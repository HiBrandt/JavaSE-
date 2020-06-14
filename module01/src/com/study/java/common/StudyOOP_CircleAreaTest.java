package com.study.java.common;

public class StudyOOP_CircleAreaTest {
    public static void main(String[] args) {

        StudyOOP_CircleArea circle1=new StudyOOP_CircleArea();
        double area1 = circle1.showArea(6);
        System.out.println(area1);

        System.out.println("面积为:"+exercise(3, 4));

    }

    // 打印并求面积
    public static int exercise(int a,int b){
        for(int i=0;i<=a;i++){
            for (int j=0;j<=b;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        int area2=a*b;
        return area2;

    }
}
