package com.study.java.common;

import org.testng.annotations.Test;

import java.util.*;

/**
 * 1.Collectons工具类    注：-->Collection是接口
 *   Collections 是一个操作 Set、 List 和 Map 等集合的工具类-->联想Arrays工具类
 * 2.方法：
 *   ①：
 *     reverse(List)： 反转 List 中元素的顺序
       shuffle(List)： 对 List 集合元素进行随机排序
       sort(List)： 根据元素的自然顺序对指定 List 集合元素按升序排序
       sort(List， Comparator)： 根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
       swap(List， int， int)： 将指定 list 集合中的 i 处元素和 j 处元素进行交换
     ②：
       Object max(Collection)： 根据元素的自然顺序，返回给定集合中的最大元素
       Object max(Collection， Comparator)： 根据 Comparator 指定的顺序，返回
       给定集合中的最大元素
       Object min(Collection)
       Object min(Collection， Comparator)
       int frequency(Collection， Object)： 返回指定集合中指定元素的出现次数
       void copy(List dest,List src)：将src中的内容复制到dest中
          -->有坑，下面代码演示
       boolean replaceAll(List list， Object oldVal， Object newVal)： 使用新值替换List 对象的所有旧值
     ③：HashMap和ArrayList都不是线程安全的，即便如此 我们也不会用vector以及Hashtable
        而是用Collections中的方法把HashMap和ArrayList变为线程安全的。如下：
          -->Collections 类中提供了多个 synchronizedXxx() 方法
          -->synchronizedList/synchronizedCollection/synchronizedSet等等
  3.小练习：如下




 *
 */
public class StudyCollection_5 {


    @Test
    public void test1(){

        ArrayList arrayList=new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        //错误的方法
        // ArrayList arrayList1=new ArrayList();
        //直接调用方法报错
        //Collections.copy(arrayList1,arrayList);

        //正确的方法  数组转为list
        List arrayList1=Arrays.asList(new Object[arrayList.size()]);
        Collections.copy(arrayList1,arrayList);
        System.out.println(arrayList1);
    }

    /**
     *
     * 请从键盘随机输入10个整数保存到List中，并按倒序、从大到小的顺序显示出来
     *
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> arrayList=new ArrayList<Integer>(3);
        for(int i=0;i<3;i++){
            int nextInt = scanner.nextInt();
            arrayList.add(nextInt);
        }

        Collections.sort(arrayList,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1-o2);
            }

        });

        System.out.println(arrayList);
    }

    /**
     *  对一个Java源文件中的关键字进行计数。
        提示： Java源文件中的每一个单词，需要确定该单词是否是一个关键字。为
        了高效处理这个问题，将所有的关键字保存在一个HashSet中。用contains()
        来测试

        ②统计姓氏出现次数 用hashmap查看是否有 有就value+1，没有就加进去，value设置为1
     */
    @Test
    public void test2(){


    }


}
