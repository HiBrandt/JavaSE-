package com.study.java.common;

public class StudyOOP_PassObject {

    public static void main(String[] args) {
        Circle c= new Circle();
        int time=5;
        printAreas(c,5);

        System.out.println("Now radius is:"+(double)(time+1));
    }

    public static  void printAreas(Circle c, int time){

        for(double i=1;i<=time;i++){
            double area = c.findArea(i);
            System.out.println(i+"           "+area);

        }

    }
}

 class Circle{

    double radius;

    public double findArea(double radius){

        this.radius=radius;
        double area=radius * radius *Math.PI;
        return area;
    }
}
