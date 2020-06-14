package com.study.java.common;

/**
 * 1.创建线程的第二种方式：实现Runnable接口.（不加锁仍然会出现超卖）
 * ①突破单继承的局限性
 * ②多个线程可以共享同一个接口实现类的对象，非常适合多个相同线程来处理同一份资源。不用加static也能实现共享数据
 * ③联系：其实Thread类也是实现的Runnable接口
 * 2.线程的状态。新建 就绪（start） 运行 阻塞 消亡
 *    -->阻塞：sleep() join() wait() 等待同步锁
 *
 *

 *
 */


public class StudyThread_2 {   //多线程时仍然出现超卖的情况

    public static void main(String[] args) {

        ThreadTest3 threadTest3=new ThreadTest3();
        Thread thread=new Thread(threadTest3);
        Thread thread2=new Thread(threadTest3);
        thread.start();  //调用的还是Thread的start方法
        thread2.start();
    }
}

class ThreadTest3 implements Runnable{

    private  int ticket=100; //只有一个对象不需要加static了
    @Override
    public void run() {

       while (true){
           if(ticket>0){
               System.out.println(Thread.currentThread().getName()+"卖第"+ticket+"票");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               ticket--;
           }else {
               break;
           }
       }

    }
}
