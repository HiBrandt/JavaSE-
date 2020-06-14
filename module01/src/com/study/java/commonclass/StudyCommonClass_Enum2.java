package com.study.java.commonclass;

/**
 * 1.使用enum定义枚举类
 *     -->默认继承Enum类，所以不能继承其他类
 *     -->不用重写toStrng了
 * 2.枚举类的所有实例必须在枚举类中显式列出(, 分隔 ; 结尾)。列出的实例系统会自动添加 public static final 修饰
 * 3.必须在枚举类的第一行声明枚举类对象
 * 4.常用方法:
 *    values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
      valueOf(String str)：可以把一个字符串转为对应的枚举类对象。
        -->要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
      toString()：返回当前枚举类对象常量的名称
   5.实现接口
      ①-->若每个枚举值在调用实现的接口方法呈现相同的行为方式，则只要统一实现该方法即可
      ②-->若需要每个枚举值在调用实现的接口方法呈现出不同的行为方式,则可以让每个枚举值分别来实现该方法
   6.注解。不用说了以后会很常见
       -->元注解：修饰注解的注解
       -->元数据：修饰数据的数据  String name="liubo"; 核心数据是"liubo",String和name是修饰liubo的
 *
 *
 */

interface info{
    void show();
}

public enum StudyCommonClass_Enum2 implements info {

    SPRING("春天"){
        @Override
        public void show() {   //分别实现
            System.out.println("这是春天");
        }
    },
    SUMMER("夏天"){
        @Override
        public void show() {
            System.out.println("这是夏天");
        }
    },
    AUTUMN("春天"),
    WINTER("冬天");


    private final  String SEASONNAME;

    private StudyCommonClass_Enum2(String SEASONNAME) {
        this.SEASONNAME = SEASONNAME;
    }

    public String getSEASONNAME() {
        return SEASONNAME;
    }

    public static void main(String[] args) {
        StudyCommonClass_Enum2 spring = StudyCommonClass_Enum2.SPRING;
        System.out.println(spring);
        spring.show();
    }

    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
}
