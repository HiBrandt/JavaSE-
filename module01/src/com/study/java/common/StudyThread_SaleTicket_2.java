package com.study.java.common;


/**
 * 1.synchronized 同步锁 同步代码块  同步方法  可以解决卖票的问题
      -->synchronized (对象){
          // 需要被同步的代码；
 *       }
 *    -->public synchronized void show (String name){ …. }
 * 2.注意：
 *    代码块：-->多个线程必须共用一把锁 p431  （哪怕是同一个Dog对象）
 *           -->锁的范围得注意，别错了
 *           -->括号里面的锁必须保证'唯一' 。继承Thread的方式，用this可能有陷阱。具体问题具体分析
 *    同步方法: 同步方法仍然涉及到锁的监视器问题，只是不需要显示的声明
 *             非静态的同步方法的监视器是this。静态的同步方法是当前类本身
 *
 *
 *
 *
 *
 *
 */
public class StudyThread_SaleTicket_2 implements Runnable {

    private  int ticket=100;
    public static void main(String[] args) {
        StudyThread_SaleTicket_2 runnable=new StudyThread_SaleTicket_2();
        Thread thread=new Thread(runnable);
        Thread thread2=new Thread(runnable);
        thread.start();
        thread2.start();

    }

    @Override
    public void run() {

        while (true){
            synchronized (this){
                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"卖第"+ticket+"票");
                    ticket--;
                }else {
                    break;
                }
            }
        }
    }
}
