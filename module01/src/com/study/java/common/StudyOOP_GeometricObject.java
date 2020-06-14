package com.study.java.common;

public class StudyOOP_GeometricObject {




    public static void main(String[] args) {

        Circle2 circle2=new Circle2();
        Circle2 circle=new Circle2();
        System.out.println(circle.toString());
        System.out.println(circle.equals(circle2));


    }






    protected String color;
    protected double weight;

    protected StudyOOP_GeometricObject(){

        color="White";
        weight=1.0;

    }
    protected StudyOOP_GeometricObject(String color ,double  weight){


    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class Circle2 extends StudyOOP_GeometricObject{

    private double radius;

    public Circle2(){
        color="White";
        weight=1.0;
        radius=1.0;

    }
    public Circle2(double radius){
        color="White";
        weight=1.0;
        this.radius=radius;

    }
    public Circle2(double radius,String color,double weight){

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea(){
        return radius*radius*Math.PI;
    }

    //传入Object代表可以传入任何对象
    @Override
    public boolean equals(Object obj) {
        if(obj==this){
            return true;
        }
        if(obj instanceof Circle2){
            Circle2 c2=(Circle2)obj;
            return c2.radius==this.radius;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Circle2 [color:"+this.color+", weight:"+this.weight+",radius:"+this.radius+"]";
    }
}
