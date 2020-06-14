package com.study.java.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 1.数组与集合
 *    -->数组：①数组在初始化后长度就确定了②声明的类型就决定了数组的类型③不便于扩展④有序的
 *            ⑤数组中提供的属性和方法比较少，不便于添加，删除和插入，并且效率不高（查询快）
 * 2.框架结构
 *     -->Collection接口 (单列数据)
 *         -->List接口 (有序，可重复)("动态"数组)
 *           -->ArrayList实现类
 *           -->LinkedList实现类
 *           -->Vector实现类
 *         -->Set接口 (无序，不能重复)
 *           -->HashSet实现类
 *           -->LinkedHashSet实现类
 *           -->TreeSet实现类
 *     -->Map接口 (映射，键值对)
 *           -->HashMap实现类
 *           -->LinkedHashMap实现类
 *           -->TreeMap实现类
 *           --Hashtable实现类
 * 3.Collection接口常用的方法：(注意参数呦,有的参数传入的是'obj'对象(证明可以不受类型的限制,一个集合装各种对象),有的是集合)
 *    添加：add(Object obj)、addAll(Collection coll)
 *    个数：int size() -->像数组和String都是length
 *    清空集合：void clear()
 *    是否为空集：boolean isEmpty()
 *    是否包含某个元素：boolean contains(Object obj)、boolean containsAll(Collection c) -->用过equals方法来判断,比较内容。
 *          -->自定义类要涉及到重写   containsAll只要有不包含就是false
 *    删除：boolean remove(Object obj) 通过元素的equals方法判断是否是要删除的那个元素。 只会删除找到的第一个元素
 *         boolean removeAll(Collection coll)： 取当前集合的差集
 *          -->equals方法找到了就删除，返回true。找不到就返回false
 *    交集：boolean retainAll(Collection c)： 把交集的结果存在当前集合中，不影响c
 *    集合是否相等：boolean equals(Object obj) list和set对有无顺序的要求还不一样呢
 *    转化为数组：Object[] toArray()  Arrays.asList()数组转化为集合
 *    获取哈希值：hashCode()
 *    遍历：iterator()： 返回迭代器对象，用于集合遍历。下面演示
 *          -->'迭代器对象'有三个方法hasNext()-->判断下一个位置是否有元素 next()-->指针会下移,并返回
 *              remove()在遍历过程中删除集合元素
 *             注意:iterator可以删除集合的元素,但是是遍历过程中通过迭代器对象的remove方法，不是集合对象的remove方法。
 *          -->注意:iterator是迭代器不是容器
 * 4.foreach第二种遍历方法。遍历集合或者数组， 快捷键iter
 *     注意：内部调用的仍然是迭代器
 * 5.笔试题：foreach和for循环的不同 下面有自己看吧
 *
 */
public class StudyCollection_1 {

    public static void main(String[] args) {

        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("库里");
        coll.add(new Circle2(12.3));
        System.out.println(coll);
        System.out.println("--------------------");

        //迭代器遍历
        Iterator iterator = coll.iterator(); //返回迭代器。检票员
        while (iterator.hasNext()){
           // System.out.println(iterator.next());//输出元素
            Object next = iterator.next();
            if(next.equals("库里")){
               iterator.remove();
            }
        }
        //foreach
        for (Object o : coll) {
            System.out.println(o);
        }


        //面试题
        String[] str = new String[]{"ll","ll","ll"}; //要么写长度不写内容，要么写内容不写长度

//        for(int j=0;j<str.length;j++){
//           str[j]="lb";
//        }

        for (String myStr : str) {
            myStr = "lb";         //相当于自己搞了一个变量myStr和原始的str数组没有关系
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }

    }
}
