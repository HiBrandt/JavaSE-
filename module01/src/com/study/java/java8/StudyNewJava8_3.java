package com.study.java.java8;


import org.testng.annotations.Test;

import java.util.Optional;

/**
 * Optional 类:为了防止空指针的。Optional<T> 类(java.util.Optional) 是一个容器类
 *   -->其实就是在可能出现空指针的情况下，搞个备选方案，备胎
 *
 *  Optional类的Javadoc描述如下：这是一个可以为null的容器对象。
 *  如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
 *
 *  创建Optional类对象的方法：
  Optional.of(T t) : 创建一个 Optional 实例， t必须非空；
  Optional.empty() : 创建一个空的 Optional 实例
  Optional.ofNullable(T t)： t可以为null
   orElse(T other) ： 如果有值则将其返回，否则返回指定的other对象。

   下面这俩方法一起用，判断不为空再调用get方法
   boolean isPresent() : 判断是否包含对象
   T get(): 如果调用对象包含值，返回该值，否则抛异常

 *
 */
public class StudyNewJava8_3 {


    /**
     * Optional.of()参数必须不为null，否则就报错
     * Optional.ofNullable();
     */
    @Test
    public void test1(){

        Girl  girl = new Girl();
      //  girl = null;
        Optional<Girl> girl1 = Optional.of(girl);  // girl不能为null
        Optional<Girl> girl2 = Optional.ofNullable(girl); //girl可以为null
        Optional<Object> empty = Optional.empty(); //创建空的 Optional实例

    }

    /**
     * 获取女孩姓名的方法
     * 可能为空针织：Boy可能为空 或者  Boy调用的是空参构造器，没有传入Girl
     * @param boy
     * @return
     */
    public String getGirlName(Boy boy){

        return boy.getGilr().getName();
    }

    /**
     * 空指针的情况很尴尬
     */
    @Test
    public void test2(){
        Boy boy = new Boy();

      //  boy = null;
        getGirlName(boy);
    }

    /**
     * 第一波优化,代码繁琐
     */

    public String getGilrName2(Boy boy){

        if(boy != null){
           if( boy.getGilr() != null){
               return boy.getGilr().getName();
           }else {
               return null;
           }
        }else {
            return null;
        }
    }

    /**
     * 测试getGilrName2  避免了空指针但是代码繁杂
     */
    @Test
    public void test3(){
        Girl girl = new Girl("杨幂");
        Boy boy = new Boy(girl);
        //boy = null;
        String name = getGilrName2(boy);
        System.out.println(name);
    }

    /**
     * 第二波优化
     */
    public String getGirlName3(Boy boy){

        Optional<Boy> boy1 = Optional.ofNullable(boy);
        //如果Optional容器中的boy为空，那么就用参数中new Boy的boy
        //如果Optional容器中的boy不为空，就用容器中的boy
        //就相当于找个备选方案
        //boy2 即可能是boy 也可以是刚传进来的boy
        Boy boy2 = boy1.orElse(new Boy(new Girl("迪丽热巴")));

        //Girl也可能是null，就是同样的逻辑了
        Girl gilr = boy2.getGilr();
        Optional<Girl> gilr1 = Optional.ofNullable(gilr);
        Girl girl = gilr1.orElse(new Girl("古力娜扎"));

        return gilr.getName();

    }

    /**
     * 测试getGirlName3
     */
    @Test
    public void test4(){
        Boy boy = new Boy();
        boy = null;
        String girlName3 = getGirlName3(boy);
        System.out.println(girlName3);
    }



}
