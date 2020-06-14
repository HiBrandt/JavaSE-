package com.study.java.common;


/**
 * 1.单元测试。类：①必须是public ②必须有无参构造器 单元测试方法:①方法权限是public，②没有返回值 ③没有形参
 * 2.static关键字:静态的,可以用来修饰属性/方法/代码块/内部类
 *   ①修饰属性:static修饰的属性又叫做静态属性。静态属性 vs 非静态属性（实例变量）
 *      -->实例变量。创建的多个对象，每一个对象独立的拥有一份类中的非静态属性，修改其中一个不会影响其他对象的属性
 *      -->静态属性变量。多个对象共同享有一个静态变量。只要其中一个对象做了修改，那么其他对象再调用时，是修改过了的（牵一发，动全身）
 *      -->静态属性随着类的加载而加载，可以直接通过 类.属性  进行调用，早于对象的创建
 *      -->类加载一次 静态属性也是加载一次，所以只有一份 保存在方法区的静态域中
 *   ②修饰方法：可以通过 类名.方法 进行调用
 *      -->静态方法中，只能调用静态的方法或属性。非静态方法既可以调非静态的属性和方法，又可以调静态的属性和方法
 *      -->静态方法中不能有this和super关键字
 *   ③通过对象既可以调非静态的属性和方法又可以调静态的。（生命周期）
 * 3.开发中，如何确定一个属性或者方法需要用static
 *    ①属性：①当属性需要被所有对象共享时，不会随着对象的不同而不同（多线程卖票）（同一时间段的利率）②类中的常量
 *    ②方法：①调用静态属性的方法，比如静态属性的get,set方法。②工具类的方法，习惯声明为静态（Math）(之前项目用的接受键盘的工具类)
 * 4.main方法
 *    ①程序的入口
 *    ②也可以作为我们和控制台的交互 --> run configurations-->Arguments 传入参数
 * 5.代码块：用来初始化类、对象。分为静态代码块和非静态代码块  （开发中相对而言用的还是比较少的）
 *   {
 *
 *   }
 *   static{
 *
 *   }
 *   ①静态代码块：
 *      -->可以写输出语句
 *      -->随着类的加载而'执行' （比方法还狠，方法还得调用，它就直接执行了）
 *      -->初始化类的信息（属性和方法）
 *      -->多个静态代码块将按照顺序执行
 *      -->只能调用静态的结构
 *   ②非静态代码块：
 *      -->可以写输出语句
 *      -->随着对象的创建而'执行'
 *      -->对对象的属性进行初始化
 *      -->多个非静态代码块将按照顺序执行
 *      -->可以调用静态的属性和方法以及非静态的属性和方法
 * 6.final-->最终的
 *     ①修饰类不能被继承-->String/System....(其实就是我这类定义的功能差不多了，不需要再扩充其他功能了)
 *     ②修饰方法不能被重写
 *     ③修饰变量-->变量就是常量，名称都是大写的。
 *        变量：属性/局部变量
 *        -->属性：可以考虑的 ‘赋值’ 的位置有：显示初始化/代码块/构造器
 *        -->局部变量：注意在修饰形参时，一旦参数赋值了就不能改变了
 *        -->static final 用来修饰属性：全局常量
 * 7.面试题：
 *      ①  return ++x;编译不通过 X不能改变  return x + 1;可以。因为我变的不是X 只是返回了x+1
        public class Something {
             public int addOne(final int x) {
             return ++x;
            // return x + 1;
        ② o = new Other(); 不行。以为不能改变不能重新new  o.i++;可以。因为不是o变化，只是i变化
         public class Something {
            public static void main(String[] args) {
                 Other o = new Other();
                 new Something().addOne(o);
            }
             public void addOne(final Other o) {
                 // o = new Other();
                 o.i++;
             }
         }
         class Other {
            public int i;
         }
 8.抽象类：抽象类是用来模型化那些父类无法确定全部实现，而是由其子类提供具体实现的对象的类。abstract 可以修饰类和方法
          -->比如交通工具类。要计算燃料效率和行驶距离。但是不同的交通工具的计算方式肯定不一样（卡车、轮船）
          -->这就可以把交通工具类定义成一个抽象类，写计算燃料效率和行驶距离的抽象方法让（卡车、轮船）去继承，去重写自己的独有的计算方式方法
     ①修饰类：-->抽象类
        -->不能实例化（编译都不通过）/抽象类一定要有构造器（子类对象实例化要调用父类的构造器）
     ②修饰方法：-->抽象方法
        -->只有方法的声明，没有方法体 --> public abstract void eat();
        -->有抽象方法的类一定是抽象类，但是抽象类不一定非要有抽象方法
        -->子类在重写了'所有'父类的抽象方法后才可以实例化,如果没有重写全部抽象方法，那么该子类还是一个抽象类，需要用abstract修饰
     ③abstract不能修饰属性、构造器等结构。不能修饰私有方法、静态方法、final方法和final类
     ④ p345一些高级的写法 要回顾
 9.模板方法设计模式
    软件开发中实现一个算法时，整体步骤很固定、通用，这些步骤已经在父类中写好了。但是某些部分易变，易变部分可以抽象出来，供不同子类实现。这就是一种模板模式
 10.接口。因为Java不支持多重继承。有了接口，就可以得到多重继承的效果。第二，有时必须从几个类中 '抽取出一些共同的行为特征'，
    而它们之间又没有is-a的关系，仅仅是具有相同的行为特征而已。比如飞机和鸟（没有is-a,但是都会飞）
       ①interface --> public interface flyable{}
       ②如何定义接口？
           -->JDK7及以前：
                -->全局常量  public static final的，但是书写时可以省略不写
                -->抽象方法  public abstract 的方法
           -->JDK8及以后：
                -->除了定义全局常量和抽象方法，还可以定义静态方法，默认方法。（越来越像类靠拢了）
                     -->静态方法。调用时必须通过接口去调用，不能通过实现类或者实现类对象去调用。
                     -->默认方法。public defeat void method(){} 。通过实现类的对象去调用。如重写，则调用的是重写的方法
                        -->若一个接口中定义了一个默认方法，而父类中也定义了一个同名同参数的非抽象方法,默认调用的是父类的方法（类优先原则）
                        -->若一个接口中定义了一个默认方法，而另外一个接口中也定义了一个同名同参数的方法（不管此方法是否是默认方法），在实现类同时实现了这两个接口时，会出现： 接口冲突。解决办法：实现类必须覆盖接口中同名同参数的方法，来解决冲突
                     如何在实现类中调用接口的默认方法?-----（接口.super.方法）


       ③接口没有构造器-->因为根本不需要继承
       ④类通过implement去实现一个接口，如果实现了所有的抽象方法，那么就可以实例化了。如果只是实现了部分的抽象方法，那么这个类就是抽象类
       ⑤先继承后实现。接口之间也可以继承的 cc接口 '继承' 了aa和bb，那么dd实现cc就要实现全部的aa，bb，cc的抽象方法
       ⑥接口也体现多态性，它是一种规范。面向接口编程。p351
       ⑦各种匿名 p352  351和352一定要看

 面试题
 interface A {
    int x = 0;
 }
 class B {
    int x = 1;
 }
 class C extends B implements A {
    public void pX() {
        System.out.println(x);   //x不明确是谁的 （X）
        System.out.println(super.x); //调用父类（√）
        System.out.println(A.x); //调用A接口的（√）
    }
    public static void main(String[] args) {
        new C().pX();   //其实就是对象.方法-->方法里面可以直接调用属性
    }
 }
  11.内部类（太烦了，省略吧）p359
  12.抽象类和接口的异同：
       相同点：都不能实例化。都可以含有抽象方法。都可以被继承（接口继承接口）
       不同点：单继承，多实现。
              抽象类有构造器，接口没有。
              接口里定义的变量只能是公共的静态的常量，抽象类中的变量是普通变量。
              关键字不同。
       **-->如果抽象类和接口都可以使用的话，优先使用接口，因为避免单继承的局限

 *
 *
 */
public class StudyOOP_4 {

    public static void main(String[] args) {
        BankAccount bankAccount=new BankAccount();
        bankAccount.setPassword(43242);
        bankAccount.setBalance(200);
        BankAccount bankAccount2=new BankAccount();
        bankAccount2.setPassword(43242);
        bankAccount2.setBalance(200);
        BankAccount bankAccount3=new BankAccount();
        bankAccount3.setPassword(43242);
        bankAccount3.setBalance(200);

        bankAccount.soutInfo();
//        bankAccount2.soutInfo();
//        bankAccount3.soutInfo();
    }


}
class BankAccount{

    private static int id=1001;//自动生成
    private int password;
    private double balance;
    //利率 -->所有的账户都是同一个利率 static
    private static double interestRate=0.0135;
    //最小余额 -->每个账户最小余额都一致
    private static double Minimal=20;

    public BankAccount() {
        id++;
    }


    public  void soutInfo(){
        System.out.print(id);
        System.out.print(interestRate);
        System.out.print(password);
        System.out.print(balance);
        System.out.print(Minimal);
    }

    public static int getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static double getMinimal() {
        return Minimal;
    }

    public static void setId(int id) {
        BankAccount.id = id;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public static void setMinimal(double minimal) {
        Minimal = minimal;
    }
}
