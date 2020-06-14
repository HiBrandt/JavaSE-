package com.study.java.reflect;


import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 *
 *   获取运行时类的完整结构
 *
 * 1.properties是读取配置文件的集合 -->test1()
 * 2.反射创建运行时类的对象：newInstance()方法  -->test2() （最常用的）
 *     -->调用此方法的运行时类必须有空参构造器
 *     -->且空参构造器的权限要足够。一般为public （所以我们再创建类时一般都要有空参构造器，方便反射使用）
 * 3.反射的动态。想登陆和注册
 * switch(变量){
 *    case 值:
 *      操作1
 *      break;
 *
 *    case 值:
        操作2
        break;
       ...
 * }
 * 4.利用反射可以获取运行时类的:（无所不包了）
 *   实现的全部接口 所继承的父类 全部的构造器 全部的方法 全部的属性
 *   --> 一个类可以通过对象获取类的信息，也可以通过运行时类对象获取类的信息
 * 5.获取全部的属性：-->test3()
 *    ① public Field[] getFields() --> 获取当前类及其父类所有声明为public的属性
 *    ② public Field[] getDeclaredFields() -->获取当前类的所有的属性包括私有的属性（不包含父类的属性）
 *   获取属性后，通过属性可以获取:
 *     --> public int getModifiers() 以整数形式返回此Field的修饰符
 *     --> public Class<?> getType() 得到Field的属性类型
 *     --> public String getName() 返回Field的名称
 * 6.获取全部的方法：
 *    ①public Method[] getMethods() -->获取当前类及其父类所有声明为public的属性
 *    ②public Method[] getDeclaredMethods() -->获取当前类的所有的方法包括私有的方法（不包含父类的方法）
 *    获取方法后，通过方法可以获取:
 *      -->public Class<?> getReturnType()取得全部的返回值
 *      -->public Class<?>[] getParameterTypes()取得全部的参数
 *      -->public int getModifiers()取得修饰符
 *      -->public Class<?>[] getExceptionTypes()取得异常信息
 * 7.获取全部的构造器：有了构造器就有对象实例了
 *     ① public Constructor<T>[] getConstructors()  返回此 Class 对象所表示的类的所有public构造方法
 *     ② public Constructor<T>[] getDeclaredConstructors() 返回此 Class 对象表示的类声明的所有构造方法
 * 8.获取全部的父类以及接口：
 *     ①获取父类 public Class<? Super T> getSuperclass()
 *     ②获取接口 public Class<?>[] getInterfaces()
 *     ③获取带泛型的父类 Type getGenericSuperclass()
 *        -->泛型类型： ParameterizedType
 *        -->获取实际的泛型类型参数数组： getActualTypeArguments()
 * 9.获取类所在的包
 *     --> Package getPackage()
 * 10.获取注解
 *     ①get Annotation(Class<T> annotationClass)
 *     ②getDeclaredAnnotations()
 */
public class StudyReflect_2 {

    /**
     *properties读取配置文件
     */
    @Test
    public void  test1() throws IOException {

        //创建Properties对象
        Properties properties = new Properties();
        //输入流
        FileInputStream in = new FileInputStream("xxxxx");
        //读取配置文件
        properties.load(in);

    }

    /**
     * 创建运行时类的对象
     */

    @Test
    public void  test2() throws Exception {

        //通过方式三获取运行时类的对象
        Class clazz = Class.forName("com.study.java.reflect.Person10");
        //获取对象
        Object o = clazz.newInstance();
        //强转
        Person10 p =(Person10) o ;

        p.setName("TOM");

        System.out.println(p);
    }

    @Test
    public void test3(){

        //通过方式一获取运行时类的对象
        Class<Person10> clazz1 = Person10.class;
        Field[] field = clazz1.getFields();
        Field[] fild2 = clazz1.getDeclaredFields();
    }


}
