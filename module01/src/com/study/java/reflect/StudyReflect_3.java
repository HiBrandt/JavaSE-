package com.study.java.reflect;


/**
 *
 *   调用运行时类的指定结构
 *
 *  1.调用指定属性 -->参数为属性名
 *    ① public Field getField(String name) 返回此Class对象表示的类或接口的指定的 public 的Field （只有public没人用）
 *    ② public Field getDeclaredField(String name)返回此Class对象表示的类或接口的指定的Field（用这个）
 *        -->然后就是get set 方法 get(Object obj) set(Object obj,Object value)
 *  2.调用指定方法
 *      -->①getMethod(String name,Class…parameterTypes)
 *          方法取得一个Method对象，并设置此方法操作时所需要的参数类型（怕重载）（又是自己和父类的所有public方法）
 *         ②getDeclaredMethod(String name,Class…parameterTypes) (获取的是类自身声明的所有方法)
 *      -->之后使用Object invoke(Object obj, Object[] args)进行调用，并向方法中传递要设置的obj对象的参数信息。
 *    invoke(Object obj, Object[] args) 参数一：方法的调用者 参数二：要调用方法的参数值
 *    注意在调用静态方法时 invoke(Object obj, Object[] args) 传入的是null（万能） 或者Person.class
 *  3.调用指定构造器
 *     -->①getConstructor(Class<?>... parameterTypes) 只返回指定参数类型访问权限是public的构造器
 *        ②getDeclaredConstructor(Class<?>... parameterTypes) 返回指定参数类型的所有构造器，包括public的和非public的，当然也包括private的
 *     -->之后就是 newInstance(构造器参数);（参数可以为空）
 *  4.setAccessible方法 重要
 *     Method和Field、 Constructor对象都有setAccessible()方法
 *     setAccessible是启动和禁用访问安全检查的开关
 *     ①设置为true使得原本无法访问的私有成员也可以访问  setAccessible(true)
 *     ②提高反射的效率。 如果代码中必须用反射， 而该句代码需要频繁的被调用， 那么请设置为true
 *
 */
public class StudyReflect_3 {
}
