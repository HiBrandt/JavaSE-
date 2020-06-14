package com.study.java.common;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 自定义泛型类:
 *   -->当一个普通的类后面加了泛型，例如<T> 就代表这是一个泛型类
 *   -->其实就是 编写该类的时候不知道类的属性的类型 就先用泛型替代
 *
   StudyGeneric_Test 是测试泛型类的

   泛型方法：
     -->泛型方法可以在非泛型类中出现，也就是泛型方法和类没有关系，泛型方法可以是静态的
     -->看下面代码是泛型方法的形式

 *
 */
public class StudyGeneric_2<T> {

    private String name;
    private int age;

    private  T t;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public StudyGeneric_2(String name, int age, T t) {
        this.name = name;
        this.age = age;
        this.t = t;
    }

    public StudyGeneric_2() {
    }

    @Override
    public String toString() {
        return "StudyGeneric_2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", t=" + t +
                '}';
    }

    //泛型方法
    public static <E> List<E> ArrayToList(E [] array){

        ArrayList<E> arrayList = new ArrayList();

        for (E e : array) {
            arrayList.add(e);
        }

        return arrayList;
    }
}

class ChildClass extends StudyGeneric_2<Integer>{

    //当我们指定了泛型父类的泛型类型时，此时该类-->ChildClass不再是泛型类

}

class ChildClass1<T> extends StudyGeneric_2<T>{

    //当我们没有指定泛型父类的泛型类型时，此时该类-->ChildClass1依然是泛型类

}

