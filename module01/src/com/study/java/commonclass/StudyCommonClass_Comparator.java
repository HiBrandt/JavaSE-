package com.study.java.commonclass;


import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * Comparator
 *   当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
 *   或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那么可以考虑使用 Comparator 的对象来排序
 *   比如之前String是按照从小到大排序的，我的临时需求需要按照从大到小，对String排序，那么久可以用了
 *
 *  Comparable和Comparator的区别：
 *     其实没啥区别，Comparable接口的比较逻辑一旦确定，那就可以保证实现Comparable接口的实现类对象再任何位置都可以比较大小
 *     Comparator接口属于临时性的比较。另外Comparator传递的是两个参数。
 *
 */
public class StudyCommonClass_Comparator {

    public static void main(String[] args) {


        Goods[] goods=new Goods[3];
        Goods huawei=new Goods("huawei",1000);
        Goods iqoo=new Goods("iqoo",1500);
        Goods xaiomi=new Goods("xiaomi",2000);

        goods[0]=huawei;
        goods[1]=iqoo;
        goods[2]=xaiomi;

        Arrays.sort(goods, new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
               // 名称从小到大，价格从大到小
                if(o1 instanceof Goods && o2 instanceof Goods){
                     Goods goods1=(Goods)o1;
                     Goods goods2=(Goods)o2;
                        if(goods1.equals(goods2)){
                            return 0;
                        }else{
                            if(goods1.getName().compareTo(goods2.getName())==0){
                                return -(Double.compare(goods1.getPrice(),goods2.getPrice()));
                            }else {
                                return -(goods1.getName().compareTo(goods2.getName()));
                            }
                        }
                }
                throw new RuntimeException("输入对象类型不匹配");
            }
        });
        System.out.println(Arrays.toString(goods));

    }

}

class Goods{

    private String name;
    private double price;


    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
