package com.study.java.java8;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *    反正是一有集合 就要想到这个玩意
 * 1.Stream java8的新特性  有点类似于Spark的RDD
 * 2.Collection是数据的存储，与内存打交道。   Stream关注的是数据的计算，与CPU打交道
 * 3.延迟执行。类似于Spark的RDD，等到最后的执行算子执行的时候才会启动
 * 4.流程：对于同一个流用了终止操作就不能再返回去调用中间操作逻辑了
 *    ①实例化
 *    ②中间操作逻辑
 *    ③终止操作
 * 5.顺序流 和 并行流
 *     -->并行流就是把内容分成多个数据块，用不同的线程分别处理每个数据块的流,不能保证顺序
 * 6.
 *   实例化：四种。前三种需要掌握，最后一种需要了解 test1()
 *   中间逻辑操作： test2()
 *     filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
       distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
       limit(long maxSize) 截断流，使其元素不超过给定数量
       skip(long n) 跳过元素，返回一个扔掉了前个空流。与 limit(n) 互补n个元素的流。若流中元素不足 n 个，则返回一个空流。与limit(n)互补
       map(Function f) 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
       flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
       sorted() 产生一个新流，其中按自然顺序排序   test3()
       sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
     终止操作：test4()
       allMatch(Predicate p) 检查是否匹配所有元素
       anyMatch(Predicate p) 检查是否至少匹配一个元素
       noneMatch(Predicate p) 检查是否没有匹配所有元素
       findFirst() 返回第一个元素
       findAny() 返回当前流中的任意元素
       count() 返回流中元素总数
       max(Comparator c) 返回流中最大值
       min(Comparator c) 返回流中最小值
       forEach(Consumer c) 内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)

       reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
          --> .reduce(0,Integer :: sum);
       reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>

       collect(Collector c)  "将流转换为其他形式。"  接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
           -->collect(Collectors.toList())











 *
 */
public class StudyNewJava8_2 {

    private int f;

    /**
     *  创建流的几种方法
     */
    @Test
    public void test1(){

        //Stream的forEach方法需要传的是一个Consumer<T>接口，这是一个函数式接口，所以可以用Lambda表达式
        // 又因为我们要实现的输出逻辑，有了现成的了，所以可以把Lambda表达式换成 方法引用。
        // 方法引用可以把左边的和右边的参数都省略，所以就变成System.out :: println

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

    @Test
    public void test2(){

        //创建流
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> employeeStream = employees.stream();

        //操作: 从第三个开始过滤薪水大于等于5000的，并且限制只要显示出2个
        employeeStream.skip(3).filter(f -> f.getSalary() >= 5000).limit(2).forEach(System.out :: println);

        //创建一个新流
        Stream<Employee> employeeStream2 = employees.stream();
        //操作给每个人的薪水加20000 --> map() --> (f.getSalary()+i)括号不能丢啊
        int i = 20000;
        employeeStream2.map(f -> f.getName()+"  "+(f.getSalary()+i)).forEach(System.out :: println);

        System.out.println("******************************************");

        // flatmap --> 扁平化 把这里大的list里面的小的list都给打散扁平化处理
        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);
        playersInWorldCup2016.add(teamWestIndies);
        playersInWorldCup2016.add(teamSriLanka);
        playersInWorldCup2016.add(teamPakistan);

        System.out.println(playersInWorldCup2016);

        List<String> flatMapList = playersInWorldCup2016.stream()
                .flatMap(pList -> pList.stream())
                .collect(Collectors.toList());

        System.out.println(flatMapList);


    }

    /**
     * 排序 自然排序 和 定制排序   自然排序不用穿参数，
     * 先按照年龄比再按照薪水比
     */
    @Test
    public void test3(){
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> employeeStream3 = employees.stream();

        //employeeStream3.sorted().forEach(System.out :: println); 报错没有实现Comparable
        //Integer.compare()   Double.compare()  用什么调就是用什么的逻辑比
        employeeStream3.sorted((o1,o2) -> {
            int compare = Integer.compare(o1.getAge(),o2.getAge());
            if(compare==0){
                return Double.compare(o1.getSalary(),o2.getSalary()) ;
            }else {
                return compare;
            }
        }).forEach(System.out :: println);

    }

    @Test
    public void  test4(){

        // anyMatch
        int i [] = new int[]{1,2,3,4,5,10,8};
        IntStream stream = Arrays.stream(i);
        boolean b = stream.anyMatch(f -> f == 5);
        System.out.println(b);

        // collect  转化为集合
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> employeeStream4 = employees.stream();
        List<Employee> employeeList = employeeStream4.collect(Collectors.toList());
        System.out.println(employeeList);

        System.out.println("******************************************");

        //reduce
        IntStream stream2 = Arrays.stream(i);
        int reduce = stream2.reduce(0,Integer :: sum);
        System.out.println(reduce);


    }

}
