package com.study.java.io;

import java.io.*;

/**
 *
 * IO流--> FileInputstream  FileOutputstream
 * 1.FileInputstream处理文本文件可能出现乱码，但是可以用来复制文件，只是不能在控制台输出而已
 * 2.用字节流复制文件 代码如下：316326
 *
 *
 */

public class StudyIO_3 {

    public static void main(String[] args) {

        String readpath = "E:\\studytest\\dir2\\idea_workspace\\Java核心技术  卷1  基础知识  原书第10版--中文版扫描--带书签已OCR.pdf";
        String writeparh = "E:\\studytest\\dir2\\idea_workspace\\copy.pdf";

        copyFile(readpath,writeparh);

    }

    //字节流复制文件
    public static void copyFile(String readpath,String writeparh){

        long start = System.currentTimeMillis(); //看搞了多长时间

        //读取和复制的文件
        File readfile = new File(readpath);
        File writefile = new File(writeparh);
        //造字节流
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(readfile);
            fileOutputStream = new FileOutputStream(writefile);

            //快递车  这里不能用字符数组了 该用字节数组
            //1024很常见
            byte b [] = new byte[1024*1024*10];
            int len;
            while ((len = fileInputStream.read(b)) != -1){

                for (int i =0;i < len;i++){
                    fileOutputStream.write(b[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //各自关流
        try {
            if(fileInputStream != null){
                fileInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(fileOutputStream != null){
                fileOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);//316326

    }

}
