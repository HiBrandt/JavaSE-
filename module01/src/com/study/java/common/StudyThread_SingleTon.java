package com.study.java.common;

/**
 * 懒汉式线程安全的
 *
 */
public class StudyThread_SingleTon {

    //私有化构造器
    private StudyThread_SingleTon(){}

    //声明对象。不创建

    private static StudyThread_SingleTon obj=null;

    //提供获取对象的静态方法。（不能通过对象调用了，只能是类，所以是静态的）
    public StudyThread_SingleTon getObj(){

        //方式1：代码块或者锁住该方法但是效率都不高
//        synchronized (this){
//            if(obj==null){
//                obj=new StudyThread_SingleTon();
//            }
//            return obj;
//        }

        //方式2：效率高点

        if(obj==null){
            synchronized (this){
                if(obj==null){
                    obj=new StudyThread_SingleTon();
                }
            }
        }
        return obj;
    }

}
