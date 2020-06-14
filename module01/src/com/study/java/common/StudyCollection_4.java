package com.study.java.common;

import org.testng.annotations.Test;

import java.util.*;

/**
 * 1.Map接口：Map与Collection并列存在。存储key-value键值对。key用set来存储，不允许重复。key和value是一对一的关系
 * 2.实现类：
 *    -->HashMap:使用频率最高，key和value允许为null，不保证顺序。效率高，线程不安全
 *       -->LinkedHashMap：可以保证按照添加的顺序实现遍历，如果有频繁的遍历操作，效率高于HashMap
 *    -->TreeMap：保证按照添加的顺序进行遍历，底层是红黑树。key的自然排序和定制排序
 *    -->Hashtable：线程安全，效率低。key和value不能存储null 其实就是synchronized
 *       -->properties：用来处理配置文件，key和value都是String
 * 3.关于map的key，value的理解：
 *    -->key:无序的，不可重复的，使用set来存储 -->key所在的类要重写hashcode方法和equals方法
 *       （自己上次只想着转hash了，没想到要重写这俩方法~~~~）（不过一般情况下都是String作为key的）
 *    -->value：无序的，可重复的，使用Collection来存储 -->value要重写equals方法-->主要是因为有contains方法要用到
 *       （自己上次只想着转hash了，没想到要重写这个方法~~~~）
 *    -->entry：无序的，不重复的，使用set来存储entry
 * 4.底层实现原理：JDK7
 *    ①HashMap map=new HashMap();在实例化后会创建一个一维数组Entry[]table，长度为16
 *    ②当调用put方法时：会通过计算key的哈希值，通过散列算法决定该元素所在数组中的位置，如果位置上没有其他元素则添加成功。
 *    如果位置有其他元素了，则会与已经存在的元素的key比较哈希值，如果哈希值不相等则添加成功。
 *    如果与已经存在的元素的key的哈希值相同，则会调用equals方法。如果返回false，添加成功，并以链表的形式链接。
 *    如果返回true，则会发生value替换的情况，即用新的value值替换旧的value值-->(情况3)
 *    注意：情况3。对比hashset，这种情况是会添加失败的，对于hashmap则会发生value的替换。
 *    ③扩容：默认扩容为原来的2倍。并将原来的数据复制过来。扩容因子为0.75
 *       -->(0.75,如果太小，数组的利用率会降低，太大，碰撞几率高导致链表又过长）
 *    ④JDK8：
 *      HashMap map=new HashMap()并不会创建长度为16的数组，当调用put的方法时才会创建。-->懒汉式
 *      JDK7只有数组+链表。JDK8:数组+链表+红黑树
 *      当链表的长度超过8，并且数组的长度超过64，此时此索引位置上的所有数据由链表变为红黑树去存储，提高比较hashcode的效率。
 * 5.扩容总结：
 *    HashMap：初始为16，扩容因子0.75，2倍扩容
 *    HashSet：初始为16，扩容因子0.75，2倍扩容
 *    Hashtable：初始为11，扩容因子0.75，2倍+1扩容
 *    ArrayList：初始为10，1.5倍扩容
 *    StringBuffer和StringBuilder:初始为16，2倍+2扩容
 * 6.谈谈你对HashMap中put/get方法的认识？如果了解再谈谈HashMap的扩容机制？默认大小是多少？
 *   什么是负载因子(或填充比)？ 什么是吞吐临界值(或阈值、 threshold)？
 * 7.LinkedHashMap去看Hashset吧，前面试验过了
 * 8.Map的常用方法：
 *   ①：
 *     Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
       void putAll(Map m):将m中的所有key-value对存放到当前map中
       Object remove(Object key)：移除指定key的key-value对，并返回value
       void clear()：清空当前map中的所有数据
       Object get(Object key)：获取指定key对应的value
       boolean containsKey(Object key)：是否包含指定的key
       boolean containsValue(Object value)：是否包含指定的value
       int size()：返回map中key-value对的个数
       boolean isEmpty()：判断当前map是否为空
       boolean equals(Object obj)：判断当前map和参数对象obj是否相等 --> 参数必须也是map
     ②：没有迭代器了 迭代器是Collection的方法
       遍历所涉及到的：看代码
       Set keySet()：返回所有key构成的Set集合
       Collection values()：返回所有value构成的Collection集合
       Set entrySet()：返回所有key-value对构成的Set集合
   9.TreeMap：要求key必须是由同一个类创建的对象 自然排序和定制排序 看下面代码  p555
   10.properties:不重要
 *
 */

public class StudyCollection_4 {


    //遍历
    @Test
    public void test1(){

        HashMap hashMap=new HashMap();

        hashMap.put(123,"ABC");
        hashMap.put(456,"DEF");
        hashMap.put(789,"JHI");

        //方式一:拿到所有的key
        Set set = hashMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
        //方式二：拿到所有的value
        System.out.println("-------------------");
        Collection values = hashMap.values();

        for (Object value : values) {   //拿到的只是变量哦
            System.out.println(value);
        }
        //方式三：拿到所有的entry,注意中间有强转的过程，不然不会调用getKey()和getValue()
        System.out.println("-------------------");
        Set set1 = hashMap.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Object next = iterator1.next();
            //强转
            Map.Entry entry=(Map.Entry)next;
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+"->"+value);

        }
        //方式四：通过方式一拿到key，调用get方法变相拿到
        System.out.println("-------------------");
        Set set3 = hashMap.keySet();
        Iterator iterator3 = set3.iterator();
        while (iterator3.hasNext()){
            Object next = iterator3.next();
            Object o = hashMap.get(next);
            System.out.println(next+"->"+o);
        }


    }

    //定制排序 按照年龄从小到大
    @Test
    public void test2(){

        //给集合或者数组的定制排序
        //没加泛型
//      TreeMap treeMap=new TreeMap(new Comparator() {
//          @Override
//          public int compare(Object o1, Object o2) {
//              if(o1 instanceof User && o2 instanceof User){
//
//                  User user1=(User)o1;
//                  User user2=(User)o2;
//
//                  return Integer.compare(user1.getAge(),user2.getAge());
//              }else {
//                  throw new RuntimeException("输入类型不匹配");
//              }
//
//          }
//      });


        //添加泛型 指明比较类型 可以省去强转
        TreeMap treeMap=new TreeMap(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {


                    return Integer.compare(o1.getAge(),o2.getAge());


            }
        });

      User user=new User("小白",12);
      User user2=new User("小红",10);
      User user3=new User("小蓝",9);
      treeMap.put(user,"1");
      treeMap.put(user2,"2");
      treeMap.put(user3,"3");

        System.out.println(treeMap);

    }
}

class User{

   private String name;

   private int age ;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class VipUser extends User{

    public VipUser(String name, int age) {
        super(name, age);
    }
}
