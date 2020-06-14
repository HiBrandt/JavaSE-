package com.study.java.exception;


/**
 * 异常：异常分为两部分。
 * 1.Error -->Java虚拟机无法解决的严重问题  StackOverflowError 和 OOM。
 * 2.Exception
 *    -->其它因编程错误或偶然的外在因素(客户、网络等等)导致的一般性问题，可以使用针对性的代码进行处理。
 *    -->比如客户输入年龄 可能输入abc，那么此时就应该抛出一个异常。
 *    面试题：
 *    运行时异常：ClassCastException ArrayIndexOutOfBoundsException NullPointerException NumberFormatException
 *    编译时异常：ClassNotFoundException IOExeption SQLException
 * 3.异常处理：在编写程序时，经常要在可能出现错误的地方加上检测的代码，如进行x/y运算时，要检测分母为0，数据为空，输入的不是数据
     而是字符等。过多的if-else分支会导致程序的代码加长、臃肿，可读性差。因此采用异常处理机制。

     异常的处理为：抓抛模型。
       抛：程序在执行过程中，一旦出现异常 就会在异常代码处生成一个异常类的对象。并将此对象抛出，抛出后就不在继续执行了
            -->异常的产生有两种形式：1.系统自动生成异常对象 2.手动生成一个异常对象，并抛出 （throw）
       抓：抓就是要处理异常。有两种方式
           -->①、try-catch-finally
           -->②、throws + 异常类型（狼来了 找大人，找军队）
   4. try-catch：
         try{
         ...... //可能产生异常的代码
         }
         catch( ExceptionName1 e ){
         ...... //当产生ExceptionName1型异常时的处置措施
         }
         catch( ExceptionName2 e ){
         ...... //当产生ExceptionName2型异常时的处置措施
         }
         finally{
         ...... //无论是否发生异常， 都无条件执行的语句
         }
      ①如果明确知道产生的是何种异常，可以用该异常类作为catch的参数；也可以用其父类作为catch的参数
      ②finally是可选的
      ③使用try将可能执行的代码包装起来，在执行过程中，一旦出现异常，就会生成一个异常对象，根据此对象的类型，去catch中匹配
      ④一旦匹配到，就进入catch中进行异常的处理，处理完成就跳出此try-catch结构，继续执行其后的代码 （疑问）（后面外面写的sout还是会执行的）
      ⑤catch中的异常类型如果没有子父类关系，那么谁在上在下无所谓，如果有子父类的关系，要求子类在上。（如果不这样，编译都不能通过）
      ⑥常用的异常处理方式：1.getMessage() 返回的是String类型 2.printStackTrace()
      ⑦在try中声明的变量出了try结构后就不能被调用
   体会1：使用try-catch-finally处理编译期异常，使得程序在编译期就不再报错，但是运行期间仍然可能报错。
         就相当于将一个编译期的异常延迟到运行期间出现  -->还是要改代码~~~
   体会2：开发中，运行时异常还是比较常见的，所以我们通常不针对 '运行时异常' 去try-catch-finally了。
   5.finally 一定会执行。比如关流啊，关数据库连接啊。因为这些JVM是不会回收的
   6."throws + 异常类型" 写在方法声明处。指明此方法在执行时，可能会出现的异常类型。
      一旦方法在执行时，出现异常，仍会在异常代码处生成一个异常类的对象，此对象满足throws后异常类型时，就会被抛出
      异常后面的代码就不会再继续执行了
   7.体会：try-catch-finally：真正的将异常处理了（这里的处理不是解决，就是换种展现异常的方法，比如弹窗...）
          throws只是将方法抛给了方法的调用者，并没有真正的去处理
   8.如何选择用try-catch-finally还是throws
     ①如果父类被重写的方法没用throws，则子类重写也不能用throws，只能用try-catch-finally
     ②如果a方法在调用几个有相互依赖关系的方法，这几个方法是递进执行的，那么这几个有关系的方法用throws的方式进行处理，而执行的方法a用try-catch-finally
   9.自定义异常类：如下
   10.子类重写的方法抛出的异常类型不能大于父类
   11.throws
     public void readFile(String file) throws FileNotFoundException {
            .............
        // 读文件的操作可能产生FileNotFoundException类型的异常
        FileInputStream fis = new FileInputStream(file);
            .............
     }
   12：throw: throw new IOException("want to throw");  -->只要new的不是runtimeException，就必须得throws
   13. throw和throws的区别：
        -->throws是声明异常（异常并不一定会出现），是处理异常的一种方式  throw是手动产生异常，异常一定会出现
        throws出现在方法函数头;而throw出现在函数体

   体会：捕获与不捕获的区别-----------****************
     前面使用的异常都是RuntimeException类或是它的子类，这些类的异常的特
     点是：即使没有使用try和catch捕获， Java自己也能捕获，并且编译通过 ( 但运行时会发生异常使得程序运行终止 )。
     如果抛出的异常是IOException等类型的非运行时异常，则必须捕获，否则编译错误。
     也就是说，我们必须处理编译时异常，将异常进行捕捉，转化为运行时异常

 *
 *
 */
public class StudyException extends Exception{

     //1.继承现有的异常结构
     //2.提供全局常量
     static final long serialVersionUID = -3387516993124229948L;
     //3.提供重载的构造器
    public StudyException() {

    }

    public StudyException(String message) {
        super(message);
    }
}
