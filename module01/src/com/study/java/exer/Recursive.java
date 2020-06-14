package com.study.java.exer;

// 递归  p215
public class Recursive {

    public static void main(String[] args) {
        System.out.println(findSum(3));
    }


    // 递归求和
    public static int findSum(int a){

        if (a==1){
            return 1;
        }else{
            return a+findSum(a-1);
        }
    }
    //斐波那切数列

}
