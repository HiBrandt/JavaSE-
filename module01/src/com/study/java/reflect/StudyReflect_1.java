package com.study.java.reflect;


/**
 * 1.反射：反射机制允许程序在执行期借助于Reflection API取得任何类的内部信息，并能直接操作任意对象的内部属性及方法
 *         -->其实就是字节码文件的对象 （就是把类封装成对象）
 *         -->类也是对象，体现了万事万物皆对象
 * 2.通过反射可以调用类的私有属性和方法（打破了封装）。之前我们是不可以调用的
 * 3.疑问：
 *   ① : 啥时候用正常new对象的方式调用属性和方法，啥时候用反射的形式调用属性和方法？
 *      -->建议：直接用new对象的形式。那啥时候用反射呢？
 *      -->反射具有动态性，当我们在开发中有的时候有时要用哪个类在开发中的时候是确定不下来的，这时候不确定使用哪个类就需要反射了
 *      -->比如主界面，你是要登陆还是要注册，这时候我们是不确定的，当用户点击之后我们才可以知道，知道后再去用相应的类，执行相应的逻辑方法
 *   ② : 反射和封装矛盾吗？
 *      -->不矛盾。封装是"建议"，反射是"非要"。
 *      -->封装的私有是建议你不要调用，因为就算你不用私有的也可以实现相同的功能
 *      -->反射是你非要用私有的，那也行。要用就用呗
 * 4.类的加载机制（粗略）：真正的是 加载/链接/初始化
 *    .java文件经过javac命令编译之后，就会生成.class的字节码文件，接着使用java.exe命令对某个字节码文件进行解释运行
 *    这时候就会将字节码文件加载到内存中，这个过程就叫类的加载，加载到内存的类就叫做运行时类，此时运行的类就是Class的一个实例
 *    （注意Class是大写的，和我们平时写的class是不一样的）
 *    换句话说：就是Class类的一个实例就是一个运行时类，这个实例是只有一个的，是唯一的。
 * 5.获取Class实例的几种方式：见代码
 *    -->1到3需要掌握，4是了解，其中方式3是最重要的，更体现动态
 * 6.补充：那些类型可以有Class实例？
 *    -->class、interface、array、enum、注解、基本数据类型
 *
 */
public class StudyReflect_1 {

    public static void main(String[] args) throws ClassNotFoundException {

         //方式一：通过类的class属性
        Class<Person10> classzz = Person10.class;
         //方式二：通过类的对象，调用getClass()方法
        Person10 p1 = new Person10();
        Class<? extends Person10> clazz1 = p1.getClass();
        //方式三：最常用的方法，通过传包名+类名的方式。真正体现了动态语言。（包名+类名可以锁定唯一的类）
        Class<?> clazz2 = Class.forName("com.study.java.reflect.Person10");
        //方式四：类的加载器
        ClassLoader classLoader = Person10.class.getClassLoader();
        Class<?> clazz3 = classLoader.loadClass("com.study.java.reflect.Person10");

    }


}

class  Person10{
    private String name;
    private int age;
    public int score;


    public Person10(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Person10() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person10{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

}


