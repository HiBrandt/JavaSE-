package com.study.java.common;

/**
 * 1.多态-->父类引用指向子类对象。事物的多种形态-->①必须有继承②必须有重写（因为运行的是子类重写后的方法）
 *     --->编译看左，执行看右。Person p1=new Man(); 编译期，只能调用父类中声明的方法不能调用子类独有的方法，运行期运行的是子类重写父类后的方法
 *     --->但是这句话只适用于方法，不适用于属性。因为属性不会重写。对于属性而言，编译和运行都看左
 * 2.多态的好处（浅体会）:
 *    calss Driver{
 *
 *        public void doData(Connection con){
 *            --->这里的参数可以传Connection的所有子类 例如：(new MysqlConnecton)/(new OrcaleConnecton)
 *            --->一个方法可以传不同的子类参数以实现代码的复用性（一种Connection多种Connection）一种事物多种形态
 *            --->方法体可以写适用于Mysql和Orcale的逻辑
 *        }
 *    }
 *    method(Object obj){…} //可以接收任何类作为其参数
 *
 *  3.有了多态之后，编译时只能调用父类的方法，但是如果想要调用子类独有的方法怎么办？--->向下转型--> Man m1=(Man)p1;
 *    ①在使用向下转型之前 必须要进行instanceof的判断  不然可能会报异常
 *    ② a instanceof A  -->如果对象a是A类的对象则返回true ,否则返回false  如果A类是B类的子类 那么a instanceof B 也是true
 *                if(p1 instanceof Man){
 *                    Man m1=(Man)p1;
 *                }
 *
 *   4.object:
 *     ①finalize() 当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法
 *     clone()   equals() hashcode() wait() notifyAll() notify() getClass() toString()
 *
 *   5.==和equals()的区别
 *     ①==是一个运算符  可以用来比较基本数据类型和引用数据类型
 *         -->在比较基本数据类型的时候 比较的是指（数据类型不一定非要相等因为可以自动转型）int 10==doble 10 返回的是true
 *         -->在比较引用数据类型的时候比较的是地址（比较的两边类型必须一致）
 *     ②equals()是一个方法 只能用于比较引用类型
 *         -->当是object中定义的equals()方法时，==和equals()都是一样的 比较的都是地址值
           -->但是 String Date File 以及包装类都自己重写了equals()方法，此时equals()比较的是“内容”是否相同
           --> x.equals(null) 永远是false
     6.通常情况下，我们自己定义的类如果要使用equals()方法时，比较的也是“内容”是否相同，这个时候就需要重写equals()方法了。如下：
     7.object的原生toString()方法 输出的是类名+@地址信息。
        -->String Date File 以及包装类都自己重写了toString()方法，使得它们输出的是“内容” 如下：
        -->我们一般也要自己重写
     8.单元测试

     9.为了让基本数据类型具有类的功能，所以引出了包装类wrapper
       ①基本数据类型转换为包装类，都是通过包装类的构造器，可以传入对应的基本数据类型值又可以传入String
          -->int i=10;Integer in1=new Integer(i) /Integer in1=new Integer("10");
          -->注意字符串不能乱用 比如Integer in1=new Integer("10abc");
          -->Boolean(类)除了传入true，其他都是false
       ②包装类转为基本数据类型-->xxxvalue-->类的对象是不能进行加减乘除运算的，但是基本数据类型可以
          -->Integer in1=new Integer("10"); in1.intvalue()-->返回值就是基本数据类型了
       ③JDK 5.0之后就有自动装箱和自动拆箱了
          --> int i=10; Integer in1=i;(自动装箱)
          --> int m=in1;(自动拆箱)
     10.String 和 基本数据类型以及包装类的转换  --->转啥用啥类
          -->基本转String。 int i=10; Sting str1=i+""; / String（注意这里是类）.valueof(i);
          -->String 转基本 Sting str2="123"; Integer（注意这里是类）.parseInt(str2)
     11.面试题
         public void method1() {
             Integer i = new Integer(1);
             Integer j = new Integer(1);
             System.out.println(i == j);// false
             Integer m = 1;
             Integer n = 1;
             System.out.println(m == n);//true
             Integer x = 128;
             Integer y = 128;
             System.out.println(x == y);//false
         }
     ps：之所以会这样是因为Integer内部定义了一个Integer[]缓存 保留了-127到128的元素 当是这个范围内的 就不去new了。提高效率

 */

public class StudyOOP_3 {

    private int age;

    private String name;

    @Override
    public boolean equals(Object obj) {
        // this 指的是当前调用equals方法的对象
        // ==比较地址
        if(this==obj){
            return true;
        }

        //判断传入的对象是否是StudyOOP_3的实例对象
        if(obj instanceof StudyOOP_3){
            StudyOOP_3 cu=(StudyOOP_3)obj;
            //name是引用类型，引用类型比较内容还是要用object原生的equals方法
            return cu.age==this.age && cu.name.equals(this.name);
        }
        return false;

    }

    @Override
    public String toString() {
        return "StudyOOP_3 [age:"+this.age+",age:"+this.name+"]";
    }

    public static void main(String[] args) {

            char[] arr = new char[] { 'a', 'b', 'c' };
            System.out.println(arr);//  abc
            int[] arr1 = new int[] { 1, 2, 3 };
            System.out.println(arr1);// [I@1540e19d
            double[] arr2 = new double[] { 1.1, 2.2, 3.3 };
            System.out.println(arr2);//  [D@677327b6

    }
}
