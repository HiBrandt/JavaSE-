package com.study.java.common;

import java.util.ArrayList;
import java.util.List;

/**
 *1.List接口：元素有序且可重复。除了从Collection集合继承的方法外，List 集合里添加了一些根据索引来操作集合元素的方法
 *    -->Arraylist、Linkedlist、Vector
 *2.Arraylist、Linkedlist、Vector三者有何异同？
 *   -->Arraylist底层是一个object类型的数组。因为数组具有索引，所以它的查询比较快。但是增删比较慢。Arraylist线程不安全
 *   因为删除和插入都会影响其后面的全部元素的位置变动。
 *   -->Linkedlist底层是一个双向链表。它的查询比较慢，但是增删比较快。因为有三部分组成（头结点、数据、尾节点）
 *   当我们增加或者删除元素时只需要该表两个元素首尾节点的指向即可。
 *   -->Vector和Arraylist底层是一样的，只不过Vector是线程安全的，因为有synchronized修饰
 *3.Arraylist源码分析：在JDK8的时候:
 *   ArrayList arrayList=new ArrayList();底层数组并没有初始化长度。==> {} 注：JDK7就初始化容量为10
 *   当我们调用add方法时，会先创建个容量为10的数组。当容量不够时，会扩容，长度为原来的1.5倍。
 *   把旧的数组的元素复制到新的扩容后的数组中去。所以当我们创建ArrayList时，如果知道元素的个数，要尽量指定容量去创建。
 *4.Linkedlist在创建的时候，内部声明了Node类型的first和last属性，默认值是null
 *  当add时，会将元素封装到node中，创建Node对象。
 *5.List的新增常用方法：
 *      void add(int index, Object ele):在index位置插入ele元素
        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
    注意：如果是把其中一个集合看做一个元素添加就用add方法。
        Object get(int index):获取指定index位置的元素
        int indexOf(Object obj):返回obj在集合中首次出现的位置
        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        Object remove(int index):移除指定index位置的元素，并返回此元素
        Object set(int index, Object ele):设置指定index位置的元素为ele
        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
 *6.遍历：①增强for循环 ②普通for循环 ③迭代器
 *7.面试题见下面
 *
 *
 */

public class StudyCollection_2 {

    public static void main(String[] args) {

//        ArrayList arrayList=new ArrayList();
//        arrayList.add("ll");
//        arrayList.add("bb");
//        Iterator iterator = arrayList.iterator();
//        while (iterator.hasNext()){
//            Object next = iterator.next();
//            System.out.println(next);
//        }


        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//


    }

    private static void updateList(List list) {

        //看是删除对象还是删除元素？
        list.remove(2);  //这里的参数指的是索引
        list.remove(new Integer(2)); //这里的参数指的是内容


    }

}
