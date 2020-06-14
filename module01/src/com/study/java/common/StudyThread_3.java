package com.study.java.common;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 1.创建多线程的方式三:实现Callable接口
 *    对比：①.可以有返回值 ②方法可以抛出异常,（能抛就能处理，就可以处理）③需要借助FutureTask类，比如获取返回结果
 *
 *
 *
 */
public class StudyThread_3 implements Callable {

    public static void main(String[] args) {

        StudyThread_3 studyThread_3 = new StudyThread_3();
        FutureTask futureTask=new FutureTask(studyThread_3);//FutureTask类 获取返回值

        //启动线程
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            Object o = futureTask.get(); //通过get方法获取返回值
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


    @Override
    public Object call() throws Exception {

        int sum =0;
        for(int i=0;i<=100;i++){
            if(i%2==0){
                sum+=i;
            }
        }
        return sum;
    }
}
