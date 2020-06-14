package com.study.java.common;

import org.testng.annotations.Test;

public class StudyGeneric_Test {

    @Test
    public void test1(){


        //当我们在new泛型类的对象的时候，如果不指明泛型的类型，
        //那么该泛型的属性的类型就会被认为是Object类型，就有点肆无忌惮的随便设置类型的感觉
        //我们通常不是这么设置的
        StudyGeneric_2 generic1=new StudyGeneric_2();
        generic1.setT("111");
        generic1.setT(123);


        //在实例化的时候就指明了泛型的类型这是常用的做法
        //泛型不能是基本数据类型
        //固定了泛型的类型就不会那么肆无忌惮了
        StudyGeneric_2<Integer> generic2=new StudyGeneric_2<>();
        generic2.setT(123);
    }

}
