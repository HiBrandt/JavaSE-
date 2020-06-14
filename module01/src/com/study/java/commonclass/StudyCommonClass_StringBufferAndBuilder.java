package com.study.java.commonclass;

/**
 * StringBuffer和StringBuilder的常用方法都是一样的。
 *
 * 1.StringBuffer代表可变的字符序列.可以对字符串内容进行增删，此时不会产生新的对象。
 *   为什么可变？
 *   value没有final声明,value可以不断扩容。
 *   感悟：其实内容都可以改变。只不过String变了后需要在常量池再重新创建。String方法好多返回的也是新串。
 *        而Bulider和BUffer的改变不需要重新产生对象而已。在原有基础上修改
 * 2.StringBuffer类不同于String，其对象必须使用构造器生成！！！！！！！~~~~~
 *   StringBuffer()默认构造器容量为16
 *   推荐：StringBuffer/StringBuilder(int size)：构造指定容量的字符串缓冲区。避免多次扩容复制
 * 3.当我们的默认长度16不够时，会自动扩容。扩容为原有长度的2倍+2，将原有数组元素复制到新的数组  ！！！！！！！！
   4. StringBuffer str1=new StringBuffer("abd"); -->底层数组的长度为19.但是 str1.length()输出的是3
   5.StringBuffer和StringBuilder以及String的异同？
       -->String不可变StringBuffer/StringBuilder可变的
       -->StringBuilder效率高、 线程不安全
       -->StringBuffer效率低、 线程安全  有synchronized修饰方法
       -->底层都是数组
   6.常用方法：
      append(xxx)  delete(int start,int end) 都是左闭右开 replace(int start, int end, String str)：
      insert(int offset, xxx)  reverse()  substring(int start,int end) length() indexOf(String str)
     增  append
     删  delete
     改  replace
     查  charAt-->返回char
     插  insert
     转  reverse
     长度 lenth
     遍历 for+charAt
 *
 */
public class StudyCommonClass_StringBufferAndBuilder {

    public static void main(String[] args) {

        StringBuffer str1=new StringBuffer("abd");

        str1.append("def");
        System.out.println(str1);

        StringBuilder str2=new StringBuilder("abc");

        System.out.println(str1.length());
        System.out.println("-------------------------------------------");

        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);// -->append会调用String.valueof(obj)-->转为String-->当obj为null时，obj就为字符串"null"
        System.out.println(sb.length());//4
        System.out.println(sb);// null
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);// 报异常了




    }




}
