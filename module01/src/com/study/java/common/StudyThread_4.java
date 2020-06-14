package com.study.java.common;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1.创建多线程的方式四:创建线程池 开发中常用。但不是现在这种形式!!!!!
 *    好处：便于管理/提高响应速度(减少线程创建时间)/降低资源消耗(频繁开关线程)
 *
 *  步骤: ①创建线程
 *        ②通过 '工具类'(静态创建 Executors.newFixedThreadPool(10);) 创造线程池
 *        ③通过线程池对象调用执行方法 execute(); /submit();
 *        ④shutdown()关闭线程池
 */
public class StudyThread_4 implements Runnable {


    @Override
    public void run() {

        for(int i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {

        StudyThread_4 studyThread_4 = new StudyThread_4();

        //创建一个可重用固定线程数的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(studyThread_4);//Runnable接口用 execute
        //executorService.submit();  callable接口用submit()
        executorService.shutdown();//关闭线程池


    }
}
