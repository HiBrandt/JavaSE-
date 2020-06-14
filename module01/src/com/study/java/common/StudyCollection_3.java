package com.study.java.common;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 1.set接口 Collection的子接口，set接口不想List接口没有提供额外的方法。无序不允许重复
 * 2.判断对象是否重复用的是 equals() 方法而不是==
 * 3.实现类：
 *    -->HashSet：按 Hash 算法来存储集合中的元素，因此具有很好的存取、查找、删除性能。可以存储null，线程不安全。
 *       -->LinkedHashSet:注意是HashSet的子类；遍历内部元素时可以按照添加顺序遍历
 *    -->TreeSet:只能放一个类的多个对象。可以按照对象的属性进行排序
 * 4.HashSet：
 *    -->当向HashSet集合中存入一个元素时，HashSet会调用该对象的 hashCode() 方法来得到该对象的hashCode值，
         然后根据hashCode值，通过某种散列函数决定该对象在 HashSet 底层数组中的存储位置。
         如果两个元素的hashCode()值相等， 会再继续调用equals方法， 如果equals方法结果
         为true， 添加失败； 如果为false，那么会保存该元素，但是该数组的位置已经有元素了，那么会通过链表的方式继续链接
 注意：hashcode值在不相等的情况下，通过散列算法所计算出来的位置也可能相同，此时不会调用equals方法。而是直接通过链表的方式添加成功
   5.理解无序性和不允许重复性：
      无序：添加元素时，通过hashcode值和散列算法决定元素存储位置
      不允许重复：如果Hashcode值相等那么就会用equals判断，如果返回true是会添加失败的。
   6.object的hashcode的方法是随机的值。
   7.注意注意：向Set中添加的数据，其所在类一定要重写hashcode方法和equals方法
      -->重写的hashcode方法和equals方法尽可能保持一致性，相等的对象必须具有相等的散列码
      -->直接用系统生成的hashcode方法和equals方法一般就可以满足需求了
   8.LinkedHashSet遍历时保证插入时顺序，遍历效率高于父类HashSet 看代码。
   9.TreeSet底层是红黑树，判断插入的对象是否相等，用的是CompareTo方法，返回0代表对象相等。自己写CompareTo很灵活哦
      -->p539定制排序 下面的treemap写了案例了
   10.去除list 中的重复数值，最简单的方法就是用set去重 代码如下
   11.经典set题目p546



 */
public class StudyCollection_3 {

    public static void main(String[] args) {

        //LinkedHashSet和HashSet的遍历区别
        LinkedHashSet set=new LinkedHashSet();
        //HashSet set=new HashSet();
        set.add("ABC");
        set.add("def");
        set.add("ll");

        for (Object o : set) {
            System.out.println(o);
        }


    }

    //给list去重
     @Test
    public void distinctList(){

         ArrayList arrayList=new ArrayList();
         arrayList.add(1);
         arrayList.add(1);
         arrayList.add(2);
         arrayList.add(3);
         arrayList.add(3);

         HashSet hashSet=new HashSet();
         hashSet.addAll(arrayList);

         ArrayList distinctList = new ArrayList(hashSet);

         System.out.println(distinctList);


     }

}
