package com.study.java.commonclass;



import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * 其他的常用类
 * 1.System：构造器是私有的，方法都是静态的直接调用就行
 *   System类内部包含in、out和err三个成员变量,分别代表标准输入流(键盘输入),标准输出流(显示器)和标准错误输出流(显示器)
 *   void exit(int status)该方法的作用是退出程序。其中status的值为0代表正常退出，非零代表异常退出。
 * 2.Math类 数学类 也是静态的
 * 3.BigInteger与BigDecimal
 *     -->BigInteger没有长度限制，可以运行比long还大的范围。
 *     -->BigDecimal 超高精确度，指定运行精确度
 *
 */
public class StudyCommonClass_Other {


    @Test
    public void testsystem(){
        BigInteger bt1=new BigInteger("42424255365464745646");
        System.out.println(bt1);
        BigDecimal bd1=new BigDecimal("3424.432424");
        BigDecimal bd2=new BigDecimal("11");
        System.out.println(bd1.divide(bd2,BigDecimal.ROUND_HALF_UP));
        System.out.println(bd1.divide(bd2,3,BigDecimal.ROUND_HALF_UP));

    }



}
