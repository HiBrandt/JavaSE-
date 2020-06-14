package com.study.java.io_exer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * 获取文本上每个字符出现的次数
 *    -->忘记写步进
 *    -->++i  不是 i++
 */
public class StudyIO_exer2 {

    public static void main(String[] args) {
        wordcount();
    }

    /**
     * java实现wordcount
     */
    public static void wordcount(){

        //要读取的文件
        File readfile = new File("E:\\studytest\\dir1\\test2.txt");
        //集合
        HashMap<String,Integer> hashMap = new HashMap();

        //将文件用字符流读进来
        FileReader fileReader = null;
        BufferedReader bufferedReader =null;

        try {
            fileReader =new FileReader(readfile);
            //缓冲流包装，提升生效率
             bufferedReader = new BufferedReader(fileReader);

            int read = bufferedReader.read();
            while (read != -1){

                char c =(char) read;
                String s = String.valueOf(c);
                int i = 1;
                //获取集合
                Integer integer = hashMap.get(s);

                if(integer == null){
                    hashMap.put(s,i);
                }else {
                    hashMap.put(s,++i);  //++i 不是i++
                }
                read = bufferedReader.read(); //步进没用快递车别忘记
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(hashMap);

        //关流
        try {
            if(bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

//    @Test
//    public void test1(){
//        HashMap <String,Integer>hashMap = new HashMap();
//        Integer integer = hashMap.get(1);
//        System.out.println(integer);
//    }

}
