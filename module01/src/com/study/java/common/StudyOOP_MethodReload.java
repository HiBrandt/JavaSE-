package com.study.java.common;

public class StudyOOP_MethodReload {

    public static void main(String[] args) {

        System.out.println(mOL(3));
        System.out.println(mOL(3,6));
        System.out.println(mOL("哈哈"));

        System.out.println(max(3,6));
        System.out.println(max(3.3,6.6));
        System.out.println(max(12.1,3.2,9.6));

    }

    public static int mOL(int a){
        return a*a;
    }

    public static int mOL(int a,int b){
        return a*b;
    }

    public static String mOL(String a){
        return a;
    }

    public static int max(int a,int b){
        if(a>b){
            return a;
        }else {
            return b;
        }

    }

    public static double max(double a,double b){
//        if(a>b){
//            return a;
//        }else {
//            return b;
//        }
        return (a>b)?a:b;
    }

    public static double max(double a,double b,double c){
        if(a>b && a>c){
            return a;
        }else if(b>a && b>c) {
            return b;
        }else {
            return c;
        }
    }

}
