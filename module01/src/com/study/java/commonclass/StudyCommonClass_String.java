package com.study.java.commonclass;

/**
 * 1.String 字符串类（final修饰不可继承）,代表不可变的字符序列。他们的值在创建后不能修改。
 *   为什么不能修改？
 *   ①String的底层维护了一个数组，并且这个数组是由private 和 final修饰的。
 *   ②通过字面常量的方式给字符串赋值（String str1="abc";）存在于方法区的常量池中,
 *     当我们重新给字符串赋值时（str1="def";）,不能使用原有的value数组，需要再重新开辟空间赋值
 *   ③常量池不允许存储相同重复内容的字符串。（String str2="def"）这个时候和str1指向的是同一个地址。公用的。
 * 2.唯一一个可以和基本数据类型初始化赋值一样的类  String str1="abc";
 * 3.String str1 = “abc”;与String str2 = new String(“abc”);的区别？
 *   ①String str1 = “abc”-->常量池
 *   ②String str2 = new String(“abc”);-->堆 （堆中的数组值，也指向了常量池）
 *   ③从②可以看出，常量池的目的是为了共享。
 * 4.p452 7分钟
 *   ①常量与常量的拼接结果在常量池。（加final就变成常量了注意p461） 且常量池中不会存在相同内容的常量
 *   ②只要其中有一个是变量，（加final就变成常量了注意p461） 结果就在堆中。相当于重新new
 *   ③如果拼接的结果调用intern()方法， 返回值就在常量池中String intern = s1.intern();System.out.println(intern);
 * 5.面试题：考察值传递和String的不可变性。
 *   虽然都是引用类型传递的是地址值，但是String是唯一比较特殊的。改不了，因为String的不可变性。而char[] ch 就被改变了
 *   public class StringTest {
         String str = new String("good");
         char[] ch = { 't', 'e', 's', 't' };
         public void change(String str, char ch[]) {
            str = "test ok";
            ch[0] = 'b';
         }
         public static void main(String[] args) {
            StringTest ex = new StringTest();
            ex.change(ex.str, ex.ch);
            System.out.print(ex.str + " and ");//good
            System.out.println(ex.ch);//best
        }
     }
   6.String的常用方法：也是从0开始的 因为底层是数组
     int length() char charAt(int index) boolean isEmpty() String toLowerCase() String toUpperCase()
     boolean equals(Object obj) 比较字符串的内容是否相同
     String substring(int beginIndex) sub:子-->返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串
     String substring(int beginIndex, int endIndex) 返回一个新字符串,它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串
     split(String regex) 按照符号切割
     String replace(char oldChar, char newChar)返回一个新的字符串 -->下面有演示
     int compareTo(String anotherString) 比较两个字符串的大小 --> 挨个比较每个元素的Unicode差值.下面有演示
     boolean contains(CharSequence s) 是否包含
     int indexOf(String str) 返回指定子字符串在此字符串中第一次出现处的索引
     boolean endsWith(String suffix)  boolean startsWith(String prefix)
     String.valueof()转为字符串 parseInt()转为int
     toCharArray()转化无char数组
   7.常见算法

 *
 *
 *
 *
 *
 */

public class StudyCommonClass_String {

    public static void main(String[] args) {

        String str1="abc";
        str1="def";
        String str2="def";
        System.out.println(str1==str2);

        String s1 = "javaEE";
        String s2 = "javaEE";
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false


        String replace = s1.replace("EE", "SE");
        System.out.println(replace);



        String str11="abc";
        String str12="acd";
        System.out.println(str11.compareTo(str12));


        System.out.println("----------------------------------------------");
        //System.out.println(p1.name .equals( p2.name)); //true
        //System.out.println(p1.name == p2.name); //true-->都指向了同一个'常量池'地址


    }

}
