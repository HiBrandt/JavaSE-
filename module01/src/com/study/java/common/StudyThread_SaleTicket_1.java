package com.study.java.common;

/**
 * 卖票 thread方式 单线程不会出现问题
 * 通过static修饰变量，多线程卖票仍然会出现超卖的情况
 */
public class StudyThread_SaleTicket_1 {

   // private static int ticket=100;  //静态的只有一份

    public static void main(String[] args) {

        //匿名对象 单线程卖票不出现问题
//        new Thread(){
//            @Override
//            public void run() {
//
//                while (true){
//                    System.out.println(Thread.currentThread().getName()+"卖第"+ticket+"票");
//                    ticket--;
                  //小心判断都进不去
//                    if(ticket==0){
//                        break;
//                    }
//                }
//
//            }
//        }.start();

        ThreadTest1 threadTest1=new ThreadTest1(); threadTest1.setName("窗口1");
        ThreadTest1 threadTest2=new ThreadTest1(); threadTest2.setName("窗口2");
        threadTest1.start();
        threadTest2.start();


    }

}

class ThreadTest1 extends Thread {
    private static int ticket=100;
    @Override
    public void run() {
        while (true) {
//            System.out.println(Thread.currentThread().getName() + "卖第" + ticket + "票");
//               ticket--;
//            if (ticket == 0) {
//                break;
//            }

            if(ticket>0){
                System.out.println(Thread.currentThread().getName() + " ：卖第" + ticket + "票");
                ticket--;
            }else {
                break;
            }
        }
    }
}
