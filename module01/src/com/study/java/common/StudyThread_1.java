package com.study.java.common;

/**
 * 1.程序、进程、线程
 * 程序：静态的二进制文件代码，静态的
 * 进程：程序启动之后，其实就是运行的程序，掌管分配资源的。动态的
 * 线程：进程的进一步细化。进程分配过的资源，给了线程，让线程去干活执行任务。
 * 2.单核CPU，是一种假的多线程。在一个时间单位内只能执一个线程的任务。收费站虽然有多条，但是只有一个收费员。但是因为
 *   时间单元特别短，所以感觉不出来。
 *     --->结论：一个CPU只能在单元时间内运行一个线程。但是可以有多个线程，只是单元时间只能运行一个。（现在的机器都是多核CPU）
 * 3.并行和并发：并行：多个CPU同时执行多个任务。并发：一个CPU"同时"执行对个任务。
 * 4.一个java程序最起码有main线程，gc线程和异常处理线程。3个线程
 * 5.多线程的优势：①提高CPU的利用率。②提高程序程序的相应，同时处理多个事情（360）。
 * 6.一个线程对象只能调用一次start()方法启动，如果重复调用了，则将抛出异常“IllegalThreadStateException” -->非法线程状态
 * 7.常用方法：
 *   -->Thread.currentThread()静态方法，获取正在执行的线程的名称
 *   -->getname();setname() 获取/设置线程名称
 *   -->yield()释放调用此方法的线程的执行权。但是可能没有效果。因为让步的线程还有可能被线程调度程序再次选中
 *   -->join()就比较厉害了，谁调用jion，就先执行谁，其他的线程会进入阻塞状态。等执行完后没其他线程才有机会执行
 *   -->stop()过时方法，中断线程
 *   -->sleep()沉睡多长时间       wait()等待 这是object的方法
 *   -->isAlive()判断线程是否存活
 *   -->getPriority() setPriority(int newPriority) 获取/设置 线程的优先级 1-10 优先级并不好用
 *
 *
 *
 */
public class StudyThread_1 extends Thread{

    public static void main(String[] args) {


        StudyThread_1 thread=new StudyThread_1();
        thread.start(); //通过'本类对象'(不是thread对象)调用start方法。
        //thread.start();  一个对象只能调用一次start()方法
        thread.setName("花花");
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //thread.stop();
        System.out.println(thread.isAlive());

        //main线程将和上面创建的thread线程交互执行。
        //多线程（但是一个时间单元只能执行一个，所以是交互的）
        for(int i=0;i<=100;i++){
            System.out.println(i+"***main()***");
        }

    }

    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            System.out.println(i+""+Thread.currentThread().getName());

        }
    }
}
