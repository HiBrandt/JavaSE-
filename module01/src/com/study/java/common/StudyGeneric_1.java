package com.study.java.common;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.泛型：抓中药的小柜子上的标签。只能放这一种。
 *    -->像数组就有类型但是集合是没有类型的，可以随便放各种类型的元素，这样其实是类型不安全的
 * 2.Generic泛型的好处：
 *    -->解决类型安全问题。（比如集合放成绩的时候，放了一个姓名进去）
 *    -->获取元素时，不需要强转
 *    -->可以保证程序在编译时就发出警告，避免ClassCastException异常。
 * 3.注意：
 *    -->泛型的类型必须是类，不能是基本数据类型
 *    -->如果实例化时没指定泛型，那么默认就是Object类型
 * 4.如何自定义泛型类/泛型接口/泛型方法 --> 看StudyGeneric_2吧
 *
 * 5.通配符：?
 *    -->比如：List<?>,Map<?,?> 它是 List<?>是List<String>、List<Object>等各种泛型List的父类
 *    -->有点像多态的意思，比如在方法传参的时候，参数定义为 List<?> ，那么就可以传入任意泛型类型的List集合，
 *    -->从而去操作各种任意泛型类型的List集合。通用/复用的方法
 * 6.通配符的读写实验。List<?>为例 看如下代码
 *    -->写：不可以写。给写通配符的List添加元素失败，说明不能添加，因为不知道通配符的元素类型是什么。
 *       如果什么都可以添加，就又会造成类型不安全的问题，但是可以添加null
 *    -->读：可以读取到，返回的类型是object
 * 7.有限制的通配符：一共分为下面两种形式吧: 看代码演示总结
 *    --><? extends Person>
 *        -->可作为Person以及Person子类 的父类 extends是<=
 *    --><? super Person>
 *        -->可作为Person以及Person父类 的父类 super是>=
 *    -->能读能写。对于第一种形式 啥都不能添加，见代码。对于第二种形式 可以添加Person及其子类
 *    -->其实有限制的通配符只是给6的通配符加了限制而已，6的范围广
 *
 */

public class StudyGeneric_1 {

    //通配符的读写演示
    @Test
    public void test1(){

        ArrayList<?> arrayList1=new ArrayList<>(); //通配符

        ArrayList<String> arrayList2=new ArrayList<>();
        arrayList2.add("AA");
        arrayList2.add("BB");
        arrayList2.add("CC");

        arrayList1=arrayList2; //把arrayList2赋给arrayList1

        System.out.println(arrayList1);
        //给写通配符的List添加元素失败，说明不能添加，因为不知道通配符的元素类型是什么。
        // 如果什么都可以添加，就又会造成类型不安全的问题
        // 但是可以添加null
        //arrayList1.add("AA");
        arrayList1.add(null);

        //读取通配符类型的List
        //可以读取到，返回的类型是object
        Object o = arrayList1.get(0);
        System.out.println(o);

    }

    @Test
    public void test2(){

        List<? extends User> list=new ArrayList<>();
        List<? super User> list2=new ArrayList<>();

        //这种 <? extends Person>形式的依然不允许添加
        //list.add(new User("小白",16));

        //VIPUser是User的子类
        List<User> list3=new ArrayList<>();
        List<VipUser> list4=new ArrayList<>();
        List<Object> list5=new ArrayList<>();

        list=list3;
        list=list4;
        //list=list5; 编译不通过 说明extends是<=

        list2=list3;
        //list2=list4; 编译不通过 说明super是>=
        list2=list5;

        //第一种形式啥都不能添加
       // list.add(new User("xiaobai",19)); 编译不通过
       // list.add(new VipUser("xiaobai",19)); 编译不通过

        //第二种形式
        list2.add(new User("xiaobai",19));
        list2.add(new VipUser("xiaobai",19));
        //list2.add(new Object()); 编译不通过




    }
}
