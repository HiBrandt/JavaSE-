package com.study.java.common;

/**
 * 计算圆的面积
 */

public class StudyOOP_CircleArea {

    double pi=Math.PI;
    double radius;

    public double showArea(double radius){
        this.radius=radius;

        if(radius<0){
            return 0;
        }else {
            double area=radius*radius*pi;
            return area;
        }


    }

}
