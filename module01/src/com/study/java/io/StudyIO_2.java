package com.study.java.io;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * IO流--> FileReader  FileWrite
 * 1.流的分类
 *    -->方向：输入流 输出流
 *    -->数据单位：字节流（操作所有非文本文件，如果不在控制台输出，就可以操作文本文件） 字符流（只能操作文本或者字符串）
 *    -->流的角色：节点流（直接对接程序或者数据源） 处理流（处理流的流，增强流的读写功能）
 * 2.架构
 *    -->四大基类：-->字节流(8 bit)：InputStream OutputStream  -->字符流：Reader Writer(16 bit)
 *    https://blog.csdn.net/qq877728715/article/details/103305194
 * 读：要读的文件必须存在--> 见代码 和 3 4
 * 3.关于异常处理 必须用 try catch finally
 * 4.①File的实例化  ②流的实例化 ③流的操作 ④流的关闭
 * 写：要写的文件可以不存在，而且可以通过参数选择是否为追加写，还是覆盖写--> 见代码
 *    -->fileWriter = new FileWriter(file,true);
 *
 * 5.复制文件（先读进来，再写出去）test4
 *
 *
 */

public class StudyIO_2 {


    /**
     * 测试FileReader
     * 读入的文件一定要存在，不然会报异常
     */
    @Test
    public void  test1()  {

        File file = new File("E:\\studytest\\dir1\\hello.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);

            int read = fileReader.read(); //读取文件字符 当读到末尾返回-1  空参是一个一个读效率低

            while (read != -1){

                //类型转换
                char data = (char)read;  //读到的结果都是数字，到末尾读的是-1,需要把数字转为字符
                System.out.print(data);
                //步进
                read = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(fileReader != null){ //如果上面出现异常 直接关闭也不太好
                fileReader.close(); //关流  别忘记了 我丢
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileReader的优化
     *
     */
    @Test
    public void test2(){

        File file = new File("E:\\studytest\\dir1\\hello.txt");
        FileReader fileReader = null;
        try {
             fileReader =new FileReader(file);
            //快递员的车
            char [] cbuf = new char[5];
            int len ; //记录每次读取的数量
            //一次读一车 车的容量是5
            //读到末尾返回-1 否则返回车的容量
            while ((len=fileReader.read(cbuf)) != -1){
                for(int i = 0;i<len;i++){   //从快递车卸货  //注意这里是len不是数组的长度 因为可能最后出现读不完数组的错误
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //关流
        try {
            if(fileReader != null){
                fileReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileWriter
     */
    @Test
    public void test3(){

        //构造File
        File file = new File("E:\\studytest\\dir1\\Hi.txt");
        //构造流
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file,true);
            fileWriter.write("I Hava a Dream"+"\r\n");
            fileWriter.write("I Want to Money");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //关流
        try {
            if(fileWriter != null){
                fileWriter.close();fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4(){

        File readfile = new File("E:\\studytest\\dir1\\test.txt");
        File writefile = new File("E:\\studytest\\dir1\\test1.txt");

        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader(readfile);
            fileWriter = new FileWriter(writefile);

            char [] cbuf = new char[10]; //快递车准备

            int len;

            while ((len=fileReader.read(cbuf)) != -1){

                  for(int i = 0; i < len;i++){
                      //卸货
                      fileWriter.write(cbuf[i]);
                  }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //关流不能这样写  要分开写  下面的才是正确的
//        try {
//            if(fileReader != null){
//                fileReader.close();
//            }
//            if(fileWriter != null){
//                fileWriter.close();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //正确的关流
        try {
            if(fileReader != null){
                fileReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(fileWriter != null){
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
