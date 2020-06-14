package com.study.java.io;

import java.io.*;

/**
 * IO流-->缓冲流（提高数据读写的速度）（开发之中是不会用到前面的四种流的）（处理流的一种）
 *   -->缓冲流要“套接”在相应的节点流之上
 *   -->BufferedInputStream 和 BufferedOutputStream
 *   -->BufferedReader 和 BufferedWriter
 *  1.关闭流的顺序和打开流的顺序相反。只要关闭最外层流即可， 关闭最外层流也会相应关闭内层节点流
 *  2.flush()可以强制将缓冲区的内容全部写入输出流,可能导致速度变慢
 *  3.先造节点流再造缓冲流
 *  4.学习+测试  缓冲流  2113

 */
public class StudyIO_4 {

    public static void main(String[] args) {
        String readpath = "E:\\studytest\\dir2\\idea_workspace\\Java核心技术  卷1  基础知识  原书第10版--中文版扫描--带书签已OCR.pdf";
        String writeparh = "E:\\studytest\\dir2\\idea_workspace\\copy.pdf";

        copyfile(readpath,writeparh);

    }

    public static void copyfile(String readpath,String writepath){

        long start = System.currentTimeMillis(); //看搞了多长时间

        File readfile = new File(readpath);
        File writefile = new File(writepath);

        //节点流
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        //缓冲流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            fileInputStream = new FileInputStream(readfile);
            fileOutputStream = new FileOutputStream(writefile);

            bis = new BufferedInputStream(fileInputStream);
            bos = new BufferedOutputStream(fileOutputStream);

            byte [] b= new byte[1024*1024*10];
            int len;
            while ((len=bis.read(b)) != -1){

                for(int i = 0; i < len; i++){
                    bos.write(b[i]);
                 //   bos.flush();  这货导致速度变慢
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //关流只需要关外层缓冲流

        try {
            if(bis != null){
                bis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(bos != null){
                bos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);//2113

    }

}
