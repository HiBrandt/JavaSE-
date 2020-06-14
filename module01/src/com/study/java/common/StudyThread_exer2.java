package com.study.java.common;

/**
 *
 * 使用两个线程打印 1-100。线程1, 线程2 交替打印
 *
 * 交替打印：线程的通信
 *
 * 1.wait()：令当前线程挂起并放弃CPU,挂起。等候其他线程调用notify()或notifyAll()方法唤醒
 * 2.notify()：唤醒正在排队等待同步资源的线程中优先级最高者结束等待（唤醒一个优先级最高的）
 * 3.notifyAll ()：唤醒正在排队等待资源的所有线程结束等待.
 * 4.上面三个方法只能出现在同步代码块和同步方法中，lock都不行。
 *   而且必须和同步监视器是同一个。即：同步监视器和调用方法的是同一个对象。
 * 5.这是object的方法
 * 面试题：sleep()和wait()有什么区别？
 *    ①两个方法都可以使线程进入阻塞状态
 *    ②sleep()定义在Thread,而wait()定义在Object
 *    ③sleep不会释放锁，wait会解锁
 *    ④wait只能在同步代码块或者同步方法中使用，而sleep就比较灵活了
 *
 *
 */

public class StudyThread_exer2 implements Runnable{

    private int i=1;
    public static void main(String[] args) {

        StudyThread_exer2 runable=new StudyThread_exer2();

        Thread thread=new Thread(runable);
        thread.setName("小明");
        Thread thread2=new Thread(runable);
        thread2.setName("小红");

        thread.start();
        thread2.start();
    }

    @Override
    public void run() {
        synchronized (this){
            while (true){
                notify(); //唤醒一个等待状态的线程
                if(i<=100){
                    System.out.println(Thread.currentThread().getName()+i);
                    i++;
                    try {
                        wait();  //线程走到这里会等待并释放锁 让其他线程进入锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }

    }
}
