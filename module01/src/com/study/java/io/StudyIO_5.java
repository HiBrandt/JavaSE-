package com.study.java.io;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * IO流-->转换流（处理流的一种）（字符流和字节流的转换）
 *   -->InputStreamReader：将InputStream转换为Reader
 *   -->OutputStreamWriter：将Writer转换为OutputStream
 * 1.很多时候我们使用转换流来处理文件乱码问题。实现编码和解码的功能
 *    -->字节、字节数组 转为 字符、字符数组 是为解码
 *    -->字符、字符数组 转为 字节、字节数组 是为编码
 * 2.字符集。-->后面的字符集参数写什么,取决于要读的文件本身的字符集编码
 *   inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
 * 3.可以读入的时候用一个字符集编码 ，读出的时候用另一种字符集编码 哈哈哈
 * 4.字符集：
 *     计算机只能识别0和1二进制数据。但是我们要的是文字，所以要让计算机识别各个国家的文字
 *     将文字用二进制数据来表示建立起一一对应的关系，就是编码表。常见的编码表：
 *      -->ASCII：美国标准信息交换码
 *      -->GB2312： 中国的中文编码表。最多两个字节编码所有字符
 *      -->GBK：GB2312的升级版
 *      -->Unicode： 国际标准码 全世界的
 *      -->UTF-8： 变长的编码方式
 * 5.Unicode和>UTF-8的关系？P600
 *      Unicode字符集只是定义了字符的集合和唯一编号
 *      -->UTF-8是Unicode的最终存储方案，也就是最终存储成什么样的字节流。
 *      Unicode编码，其实就是对UTF-8、UCS-2/UTF-16等具体编码方案的统称而已，并不是具体的编码方案
 *      -->UTF-8、UCS-2/UTF-16等编码方案统称为Unicode
 *
 *
 *
 */
public class StudyIO_5 {


    @Test
    public void test1(){
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            fileInputStream = new FileInputStream(new File("E:\\studytest\\dir1\\test.txt"));

            //将字节流转化为字符流
            inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");

            int len;
            char [] c= new char[50];

            while ((len=inputStreamReader.read(c)) != -1){
                //将数组转为字符串输出
                String str = new String(c,0,len);
                System.out.println(str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //关流 也是关最外层
        try {
            if(inputStreamReader != null){
                inputStreamReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
