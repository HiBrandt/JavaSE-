package com.study.java.commonclass;

/**
 * 1.枚举类。当类的对象只有有限个的时候（四季/线程的状态...）并且是确定的，我们称之为枚举类
 * 2.当需要定义一组常量的时候，强烈建议使用枚举类
 * 3.如果枚举类只有一个对象，那么就可以理解为单例模式了
 * 4.自定义枚举类：
 *     -->私有化构造器。保证不能在外面new对象
 *     -->在类的内部创建枚举类的实例 public static final
 *     -->枚举类的属性为private final，并且必须在内部创建实例时初始化属性
 *
 *
 */
public class StudyCommonClass_Enum {


    // final修饰的变量要大写的哦
    private final String SEASONNAME; //季节名称
    private final String SEASONDESC; //季节描述

    //私有化构造器
    private StudyCommonClass_Enum(String SEASONNAME, String SEASONDESC) {
        this.SEASONNAME = SEASONNAME;
        this.SEASONDESC = SEASONDESC;
    }

    //内部创建实例 要用类去调用所以是final，而且不能被修改
    public static final StudyCommonClass_Enum SPRING=new StudyCommonClass_Enum("春天","春年花开");
    public static final StudyCommonClass_Enum SUMMER=new StudyCommonClass_Enum("夏天","夏日炎炎");
    public static final StudyCommonClass_Enum AUTUMN=new StudyCommonClass_Enum("秋天","秋高气爽");
    public static final StudyCommonClass_Enum WINTER=new StudyCommonClass_Enum("冬天","冰天雪地");

    //get方法 获取对象属性
    public String getSEASONNAME() {
        return SEASONNAME;
    }

    public String getSEASONDESC() {
        return SEASONDESC;
    }
    //toString


    @Override
    public String toString() {
        return "StudyCommonClass_Enum{" +
                "SEASONNAME='" + SEASONNAME + '\'' +
                ", SEASONDESC='" + SEASONDESC + '\'' +
                '}';
    }


    public static void main(String[] args) {

        String s = StudyCommonClass_Enum.SPRING.toString();
        System.out.println(s);

    }
}
