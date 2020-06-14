package com.study.java.exer;


//p436
public class Deadlock {

    public static void main(String[] args) {

        StringBuffer str1=new StringBuffer();
        StringBuffer str2=new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (str1){
                    str1.append("a");
                    str2.append("1");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (str2){
                    str1.append("b");
                    str2.append("2");
                }

            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (str2){
                    str1.append("c");
                    str2.append("3");
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (str1){
                    str1.append("d");
                    str2.append("4");
                }
            }
        }).start();

        System.out.println(str1);
        System.out.println(str2);

    }


}
