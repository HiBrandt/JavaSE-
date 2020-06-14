package com.study.java.java8;

import org.testng.annotations.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;

import static java.lang.Integer.compare;

/**
 *
 * java8新特性
 * 1.Lambda表达式
 *  ①-->举例：Comparator com = (o1, o2) -> Integer.compare(o1, o2);  注意compare在这里是作为方法体出现的不是作为方法
 *       感悟：compare(T o1, T o2) 和 compareTo(T o) 既可以作为重写的方法又可以作为比较逻辑的方法体 -->test()
 *  ②-->格式：
 *     -> lambda 为操作符
 *     左边是lambda形参列表（其实就是接口抽象方法的形参列表） 右边是代表lambda体 （其实就是重写的方法的方法体）
 *  ③-->六种情况p668总结：
 *      左边参数的参数类型可以省略（类型推断）；如果参数只有一个的话，其中小括号也可以省略()
 *      右边方法整体应该是使用一对{}包裹：但是如果方法体只有一条执行语句的话（可能是return语句），可以省略一对{} 和return 关键字
 *      ps：只要省略了大括号就一定要省略return关键字
 *  ④lambda表达式的本质就是一个函数式接口的实例。
 *    函数式接口：接口只有一个抽象法，及时函数式接口
 * 2.再次感受:happyTime() test2() test3() 感悟：真就是作为一个函数式接口的实例，牛逼
 *     重要：-------------------------------------------
 *     -->①用来重写抽象方法，然后再调用-->test1()  作为实例参数的传递-->test3()
 *
 * 3.方法引用：当lambda表达式的方法体（也就是右边），已经有方法的实现了，就可以使用方法引用
 *            -->（其实就是不想写方法体了，调用一下别人已经实现好的方法逻辑）参数都不用写
 *    ①格式：--> 对象/类 :: 方法名
 *         三种情况：1） 对象 :: 非静态方法名  test4()
 *                  要求：-->接口中的抽象方法的形参列表和返回值类型与方法引用的形参列表和返回值类型要一样
 *
 *                  2） 类 :: 静态方法名 test5()
 *                  要求：-->接口中的抽象方法的形参列表和返回值类型与方法引用的形参列表和返回值类型要一样
 *
 *                  3） 类 :: 非静态方法名 （和面向对象有点出入）不是很重要，感觉开发中完全可以用其他的替代
 * 4.构造器引用 ClassName::new
 *     比如： Fuction<Integer,MyCalss> fun = (n) -> new MyCalss(n);
 *     等于： Fuction<Integer,MyCalss> fun = MyCalss::new;
 * 5.数组引用  type[] :: new
 *
 *
 */
public class StudyNewJava8_1 {


    /**
     * 原始版本
     */
    @Test
    public void test(){
        //创建接匿名实现类的的对象
        Comparator<Integer> com2 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return compare(o1, o2);
            }
        };
    }


    /**
     * lambda
     */
    @Test
   public void test1(){
       Comparator<Integer> com = (o1, o2) -> compare(o1, o2);

       int compare = com.compare(3, 4);

       System.out.println(compare);
   }



   public void happyTime(double money , Consumer<Double> con){

       con.accept(money);
   }


   @Test
   public void test2(){
        happyTime(300, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("消费"+aDouble+"元");
            }
        });
   }

    @Test
    public void test3(){

        happyTime(300,money -> System.out.println("消费"+money+"元"));
    }

    /**
     * 方法引用
     */
    @Test
    public void test4(){
        //lambda 表达式写法-->这里是抽象方法的重写，就重写做了一个简单的输出
        Consumer<String> con = str -> System.out.println(str);
        //调用重写后的抽象方法
        con.accept("北京");

        //方法引用  参数都给省了
        PrintStream out = System.out;  //对象
        Consumer<String> con2 = out :: println;
        con2.accept("beijing");

    }

    @Test
    public void test5(){
        // lambada
        Comparator<Integer> con1 = (o1,o2) -> compare(o1,o2);
        int compare = con1.compare(1, 2);
        System.out.println(compare);
        //方法引用 参数都不用写
        Comparator<Integer> con2 = Integer :: compare;

    }



}
