package com.study.java.common;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1. lock锁  lock是有个接口 他的实现类是ReentrantLock
 *     -->Lock lock=new ReentrantLock(true);  true为公平锁，默认为false
 *     lock.lock();
 *     try{
 *       ........
 *     }finally{
 *       lock.unlock();
 *     }
 *
 * synchronized和lock的异同：
 *     ①synchronized。不用主动的释放锁。lock需要调用 unlock()释放锁
 *     ②synchronized是非公平锁，lock可以选择是否为非公平
 *     ③两者都可以解决线程安全的问题
 *
 *  解决线程安全问题三种方法：①synchronized代码块②synchronized方法③lock锁
 *     鼓励使用lock锁
 *
 *
 */
public class StudyThread_SaleTicket_3 implements Runnable {

    Lock lock=new ReentrantLock(true); //lock锁

    public static void main(String[] args) {
        StudyThread_SaleTicket_3 runable=new StudyThread_SaleTicket_3();
        Thread thread1=new Thread(runable);thread1.setName("窗口1");
        Thread thread2=new Thread(runable);thread2.setName("窗口2");
        Thread thread3=new Thread(runable);thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();

    }

    private int ticket=100;
    @Override
    public void run() {

        while (true){

            lock.lock(); //锁住
            try {
                if (ticket>0){
                    System.out.println(Thread.currentThread().getName()+"卖第"+ticket+"票");
                    ticket--;
                }else {
                    break;
                }
            }finally {
                lock.unlock(); //解锁
            }

        }
    }
}
