package com.study.java.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  数组
    1.数组是引用数据类型但是可以存储任何数据类型 2.长度确定不能修改 3.在内存中是一块连续的空间
    声明和赋值是两回事
    数组初始化1.静态初始化:声明+赋值  int[]array1=new int[]{1,2,3}
    2.动态初始化: 声明+指明长度  int [] array2=new int[3]
    内存
    1.只要是看到new就代表重新再堆内存中开辟一块空间
    2.局部变量存放在栈(stack)中，存放的是地址 地址是可以改变的，指向新的地址
 */
public class StudyArray {

    public static void main(String[] args) {
        //highestScore();
        testArray();
    }


    //从键盘读入学生成绩，找出最高分，并输出学生成绩等级
    // 学会利用数据结构的思想  这肯定是用到数组的  借助数据结构这种思想很重要
    //先读入学生人数，根据人数创建int数组，存放学生成绩
    public static void highestScore(){
        int max=0;
        System.out.print("请输入学生人数:");
        Scanner sc=new Scanner(System.in);
        // 学生人数
        int num = sc.nextInt();
        int [] score=new int[num];
        System.out.print("请输入学生成绩:");
        for (int i=0;i<score.length;i++){
            score[i]=sc.nextInt();
            //找最高的分数  我竟然没有想起来 真垃圾
            if(score[i]>=max){
                max=score[i];
            }

        }
        System.out.print("学生的最高分为:"+max+"  学生的成绩为:"+Arrays.toString(score));

        // 二维数组的遍历
        //静态初始化不可以指定长度
        int [][] twoArray=new int[][]{{1,2,3},{20,5,2},{3,7,23},{1,99}};

        for (int x=0;x<twoArray.length;x++){
            for (int y=0;y<twoArray[x].length;y++){
                System.out.print(twoArray[x][y]+",");
            }
        }
    }

    //定义一个int型的一维数组，包含10个元素，分别赋一些随机整数，然后求出所有元素的最大值， 最小值，和值， 平均值， 并输出出来
    public static void testArray(){
        int [] array1=new int[10];
        int max=0;
        int sum=0;
        double avg;
        // 随机数赋值
        for(int i=0;i<array1.length;i++){
            array1[i]=(int) (Math.random()*90+10);
        }
        System.out.println(Arrays.toString(array1));
        //最大值
        for (int j=0;j<array1.length;j++){
            if(array1[j]>=max){
                max=array1[j];
            }
            sum+=array1[j];
        }
            //强转double 不然失真
            avg=(double) sum/array1.length;
        System.out.println("最大值为:"+max+",和值为:"+sum+",平均数为:"+avg);

        int [] array2=new int[]{2,3,5,7,11,13,17,19};
        int [] array3=new int[8];
        // 把array2的地址给了array3 所以是同一份地址（给的是地址）俩变量共享一份地址
        array3=array2;
        // 复制数组（不共享地址，单独的） 可以用for循环复制 这里就不写了 很简单
        //把array3的偶数位置的元素赋值
        for(int x=0;x<array3.length;x++){
            if(x%2==0){
                array3[x]=x;
            }
        }
        // 因为是同一份地址 所以array3改了array2也就改了
        System.out.println(Arrays.toString(array3));
        System.out.println(Arrays.toString(array2));

        // 数组的翻转
        // ① 中间变量交换元素   记得长度除2，不然翻转了就又转回去了
        int tmp;
        for(int i=0;i<array3.length/2;i++){
            tmp=array3[i];
            array3[i]=array3[array3.length-i-1];
            array3[array3.length-i-1]=tmp;
        }
        System.out.println("翻转的为:"+Arrays.toString(array3));
        // ② 利用角标的迁移  先定好角标  角标的原则就是不碰头  其他的和上面的交换思想都一样
        for(int head=0,tail=array3.length-1;head<tail;head++,tail--){
            tmp=array3[head];
            array3[head]=array3[tail];
            array3[tail]=tmp;
        }
        System.out.println("再翻转的为:"+Arrays.toString(array3));

        // 数组的查找  ①线性查找  ②二分查找
        //①
        String [] str=new String[]{"AA","BB","HH","MM","NN","BB"};
        boolean flag=false;
        for (int i =0;i<str.length;i++){
            // 在引用数据类型中 equals 比较的是内容
           if(str[i].equals("BB")){
               System.out.println("位置为:"+i);
               flag=true;
           }
        }
        // 这个没找到要学习一下
        if(flag==false){
            System.out.println("没找到");
        }
        //② 二分查找 前提是数组必须有序
        int []arr4=new int[]{-10,3,5,7,10,89,100};

        //角标
        int start=0;
        int end=arr4.length-1;
        boolean bl=true;
        //要查找的数字
        int find=89;
        //原则是首要小于等于尾  不能越界了 哈哈
        while (start<=end){      //括号里是循环执行的条件不是循环终止的条件 傻逼了！！
            //中间索引 在不断变化
            int mid = (start+end)/2;
            if(find==arr4[mid]){
                System.out.println("找到位置了,索引位置为:"+mid);
                bl=false;
                break;
            }else if(find>arr4[mid]){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        if(bl==true){
            System.out.println("很遗憾没有找到");
        }

    }

}
