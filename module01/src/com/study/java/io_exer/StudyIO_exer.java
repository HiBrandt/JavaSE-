package com.study.java.io_exer;

import java.io.File;

/**
 *
 *  遍历指定目录所有文件名称，包括子文件目录中的文件。 --> StudyIO_exer
    拓展1：并计算指定目录占用空间的大小
    拓展2：删除指定文件目录及其下的所有文件
 *
 */
public class StudyIO_exer {

    public static void main(String[] args) {

      File file = new File("E:\\studytest");
      printfile(file);
      System.out.println(getFileSize(file));
      deleteFile(file);

    }

    /**
     * 遍历指定目录下的文件以及目录名称
     */
    public static void printfile(File file){

        if (file.exists()){
            //这里应该拿的是全部路径输出的
            File[] files = file.listFiles();
                for (File s : files) {
                    if(s.isFile()){
                        System.out.println(s);
                    }else if (s.isDirectory()){
                     //   System.out.println(s);
                        printfile(s);
                    }
                }
        }else {
            System.out.println("目录不存在");
        }

    }

    /**
     * 计算指定目录占用空间的大小
     */

    public static long getFileSize(File file){

        Long filesize=0L; //文件大小值

        if(file.exists()){

            File[] files = file.listFiles();
            for (File file1 : files) {
                if(file1.isFile()){
                    filesize+=file1.length();
                }
                if(file1.isDirectory()){
                    getFileSize(file1);
                }
            }
        }else {
            throw  new  RuntimeException("目录不存在");
        }
        return filesize;

    }
    /**
     * 删除指定文件目录及其下的所有文件
     */

    public static void deleteFile(File file){
        if(file.exists()){
            File[] files = file.listFiles();

            for (File file1 : files) {
                //判断是否为文件
                if(file1.isFile()){
                    boolean delete = file1.delete();
                    if(delete){
                        System.out.println("删除成功");
                    }else {
                        System.out.println("删除失败");
                    }
                }
                //判断是否是目录
                if(file1.isDirectory()){
                    deleteFile(file1);
                }
            }
        }
    }


}
