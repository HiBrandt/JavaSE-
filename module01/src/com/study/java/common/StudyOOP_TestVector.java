package com.study.java.common;


import java.util.Scanner;
import java.util.Vector;

/**
     * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出
     最高分，并输出学生成绩等级。
     提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的
     长度。而向量类java.util.Vector可以根据需要动态伸缩。
     创建Vector对象： Vector v=new Vector();
     给向量添加元素： v.addElement(Object obj); //obj必须是对象
     取出向量中的元素： Object obj=v.elementAt(0);
     注意第一个元素的下标是0，返回值是Object类型的。
     计算向量的长度： v.size();
     若与最高分相差10分内： A等； 20分内： B等；
     30分内： C等；其它： D等
 */
public class StudyOOP_TestVector {

    public static void main(String[] args) {
        findScore();
    }

    public static void findScore(){
        Vector vector = new Vector();
        boolean flag=true;
        System.out.println("请输入学生成绩输入为负数时结束:");
        Scanner sc=new Scanner(System.in);
        while (flag){
            int i = sc.nextInt();
            if(i<0){
                flag=false;
                break;
            }
            //自动装箱
            Integer in1=i;
            vector.add(in1);

        }
        int max=0; //中间变量
        for(int i=0;i<vector.size();i++){
            Object o = vector.elementAt(i);
            // obj 转int
            int i1 = Integer.parseInt(o.toString());
            if(i1>=max){
                max=i1;
            }
        }
        if(vector.size()>1){
            System.out.println("最高分为"+max);
        }
        for(int j=0;j<vector.size();j++){
            Object o1 = vector.elementAt(j);
            // obj 转int
            int i2 = Integer.parseInt(o1.toString());
            if(max-i2<10){
                System.out.println(i2+"为A等");
            }else if(max-i2<20){
                System.out.println(i2+"为B等");
            }else if(max-i2<30){
                System.out.println(i2+"为C等");
            }else {
                System.out.println(i2+"为D等");
            }
        }


    }
}
