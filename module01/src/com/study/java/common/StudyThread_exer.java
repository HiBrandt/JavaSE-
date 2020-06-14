package com.study.java.common;


/**
 *
 *  银行有一个账户。有两个储户分别向同一个账户存3000元，
    每次存1000， 存3次。每次存完打印账户余额

 */
public class StudyThread_exer implements Runnable {

    private int account;

    public static void main(String[] args) {

        StudyThread_exer runnable=new StudyThread_exer();
        Thread thread=new Thread(runnable);
        thread.setName("储户1");
        Thread thread2=new Thread(runnable);
        thread2.setName("储户2");

        thread.start();
        thread2.start();





    }

    @Override
    public void run() {
        synchronized (this){
            for(int i=1;i<=3;i++){
                account+=1000;
                System.out.println(Thread.currentThread().getName()+"向账户存了"+1000+"元,账户余额为:"+account);
            }
        }


    }
}
