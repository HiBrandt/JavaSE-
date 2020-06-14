package com.study.java.common;

public class StudyOOP_TirAngleTest {

    public static void main(String[] args) {

        TirAngle ti=new TirAngle(3,4);

       // ti.setHeight(3);
        System.out.println("base："+ti.getBase()+",height: "+ti.getHeight()+",Area："+ti.findArea());
    }
}

class TirAngle{
    private double base;
    private double height;

    // void 为set方法
    public void setBase(double a){
            if(a<=0){
                return;
            }
            base=a;
    }

    public void setHeight(double b){
        if(b<=0){
            return;
        }else {
            height=b;
        }
    }
    // get方法返回值类型要有
    public double getBase(){
        return base;
    }

    public double getHeight(){
        return height;
    }

    //构造器  直接初始化属性
    public TirAngle(double b,double h){
        base=b;
        height=h;
    }
    //求面积的方法
    public double findArea(){
        return base*height*0.5;
    }


}