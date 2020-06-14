package com.study.java.exer;


/**
 * 单例模式：就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例
 *   ①饿汉式
 *     -->好处：线程安全
 *     -->坏处：浪费内存，不使用的时候也会创建对象
 *   ②懒汉式
 *     -->好处：节省内存，使用的时候才会创建对象
 *     -->坏处：线程不安全
 *   ③单例模式的应用场景
 *     -->网站计数器/应用程序的日志/数据库连接池/手机APP/读取配置文件的类
 */

/**
 * 饿汉式
 */
public class SingelTonTest {

    public static void main(String[] args) {

        // 多次调用饿汉式返回的是相同的地址值
        System.out.println(HungrySingelTonTest.getInstance());
        System.out.println(HungrySingelTonTest.getInstance());

        // 多次调用懒汉返回的是相同的地址值
        System.out.println(LazySingelTonTest.getInstance());
        System.out.println(LazySingelTonTest.getInstance());


    }

}

/**
 * 饿汉式
 */
class  HungrySingelTonTest{

    //1.私有化构造器,使不能调用构造器new对象
    private HungrySingelTonTest() {

    }

    //2.内部创建对象，也是私有的，不能外部调用
    //4.此实例对象也必须静态化，不然下面获取对象的方法不能返回调用了
    private static HungrySingelTonTest hungrysingeltonTest=new HungrySingelTonTest();

    //3.提供公共的获取内部创建的对象的方法
    //     -->但是不能通过对象去调用方法了，那只能通过类去调用 所以是static
    public static HungrySingelTonTest getInstance(){

        return hungrysingeltonTest;
    }

}

/**
 * 懒汉式
 */
class LazySingelTonTest{

    //1.私有化构造器,使不能调用构造器new对象
    private LazySingelTonTest() {

    }

    //2.内部 ‘声明’对象，（比较懒不初始化）也是私有的，不能外部调用
    //4.此实例对象也必须静态化，不然下面获取对象的方法不能返回调用了
    private static LazySingelTonTest lazysingeltonTest;

    //3.提供公共的获取内部创建的对象的方法
    //  -->但是不能通过对象去调用方法了，那只能通过类去调用 所以是static
    public static LazySingelTonTest getInstance(){
        //必须加判断不然反复调用此方法就会反复创建对象了
        if(lazysingeltonTest==null){
            lazysingeltonTest =new LazySingelTonTest();
        }
        return lazysingeltonTest;
    }



}


