package com.study.java.commonclass;


/**
 *
 * 1.基本数据类型比较大小或者排序可以用== >= > < 等比较运算符。
 *   但是很多时候我们也需要对对象进行排序。-->比较器 Comparable/Comparator
 *     自然排序： java.lang.Comparable
 *     定制排序： java.util.Comparator
 * 2.String和包装类都重写了compareto方法实现了从大到小的比较与排序
 * 3.实现comparable，重写compareto方法的重写规则：
 *    如果当前对象this大于形参对象obj， 则返回正整数，
      如果当前对象this小于形参对象obj， 则返回负整数，
      如果当前对象this等于形参对象obj， 则返回零
   4.~~~~~!（意境）!当我们把多个对象存入数组中时，如果要对数组中的对象进行排序，
     调用Arrsy.sort(); 会自动调用我们自己重写的compareTo方法，对数组中的对象进行排序
 *
 *
 */

public class StudyCommonClass_Comparable implements Comparable{


    private String name;
    private int age;

    public StudyCommonClass_Comparable(String name, int age) {
        this.name = name;
        this.age = age;
    }


    //先按照年龄进行排序，再按照姓名进行排序
    @Override
    public int compareTo(Object o) {

        if(o instanceof StudyCommonClass_Comparable){
            StudyCommonClass_Comparable o1=(StudyCommonClass_Comparable)o;

            if(this.age>o1.age){
                return 1;
            }else if(this.age<o1.age){
                return -1;
            }else {
             //   return 0;  如果只是按照年龄排序就到这里可以了

                return this.name.compareTo(o1.name);  //String类型重写了直接用就可以
            }
        }
        //抛异常  竟然没有想起throw  垃圾
        throw  new RuntimeException("输入对象不匹配");

    }


    public static void main(String[] args) {

        StudyCommonClass_Comparable com1=new StudyCommonClass_Comparable("小红",10);
        StudyCommonClass_Comparable com2=new StudyCommonClass_Comparable("小名",10);

        int i = com1.compareTo(com2);
        System.out.println(i);

    }
}
