package com.study.java.common;

/**
 *     比较的对象的接口
 *          ↓
 *       圆想比半径....（等等还有其他想比较的）
 *          ↓
 *       那就专门给圆写个类继承圆类实现比较对象的接口,实现专门针对圆的比较方法
 */
public class StudyOOP_InterfaceTest {

    public static void main(String[] args) {

        ComparableCircle comparableCircle = new ComparableCircle(5);
        ComparableCircle comparableCircle2 = new ComparableCircle(5);
        double v = comparableCircle.compareObject(comparableCircle2);
        System.out.println(v);

    }

}

interface InterfaceTest{

    public abstract double compareObject(Object object);

}

class Circle3{

    private  double redius;

    public Circle3(double redius) {
        this.redius = redius;
    }

    public double getRedius() {
        return redius;
    }

    public void setRedius(double redius) {
        this.redius = redius;
    }
}

class  ComparableCircle extends Circle3 implements InterfaceTest{


    public ComparableCircle(double redius) {
        super(redius);
    }


    @Override
    public double compareObject(Object object) {
        if(object instanceof Circle3){
            Circle3 circle3=(Circle3)object;
            return this.getRedius()-circle3.getRedius();
        }
        return 0.000; //应该是抛异常的

    }
}
