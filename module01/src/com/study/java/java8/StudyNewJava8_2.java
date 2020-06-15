package com.study.java.java8;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * 1.Stream java8的新特性  有点类似于Spark的RDD
 * 2.Collection是数据的存储，与内存打交道。   Stream关注的是数据的计算，与CPU打交道
 * 3.延迟执行。类似于Spark的RDD，等到最后的执行算子执行的时候才会启动
 * 4.流程：
 *    ①实例化
 *    ②中间操作逻辑
 *    ③终止操作
 * 5.顺序流 和 并行流
 *     -->并行流就是把内容分成多个数据块，用不同的线程分别处理每个数据块的流,不能保证顺序
 *   实例化：四种。前三种需要掌握，最后一种需要了解 test1()
 *
 */
public class StudyNewJava8_2 {


    /**
     *
     */
    @Test
    public void test1(){

        //通过集合
        List<Employee> employees = EmployeeData.getEmployees();
        //顺序流
        Stream<Employee> stream1 = employees.stream();
        stream1.forEach(System.out::println);

        System.out.println();

        //并行流
        Stream<Employee> stream2 = employees.parallelStream();
        stream2.forEach(System.out::println);

        System.out.println();

        //通过数组的工具类
        int i [] = new int[]{1,2,3,4,5,10,8};
        IntStream stream = Arrays.stream(i);
        stream.forEach(System.out :: println);

        //通过Stream的of() 返回一个流
        Stream<List<Employee>> employees1 = Stream.of(employees);


    }

}
