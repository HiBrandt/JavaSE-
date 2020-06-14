package com.study.java.io;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * 1.文件类 File类  File类的对象可以表示为目录或者文件  三个构造器
 * 2.相对/绝对路径
 * 3.win下是\\ 其中一个是转移符  linux是/
 * 4.注意当我们New出File的对象时，并没有创建文件
 * 5.常用方法：
 *   ①：
 *   public String getAbsolutePath()： 获取绝对路径
     public String getPath() ： 获取路径
       -->上面两个方法的区别下面代码演示了
       -->第一个就是获取绝对路径
       -->第二个就是获取路径，取决于当时new对象的路径参数

     public String getName() ： 获取文件名称
     public String getParent()： 获取上层文件目录路径。 若无， 返回null
     public long length() ： 获取文件长度（即：字节数） 。 不能获取目录的长度
     public long lastModified() ： 获取最后一次的修改时间， 毫秒值

     ②：
     public String[] list() ： 获取指定目录下的所有文件或者文件目录的名称数组
        -->获取的是指定目录下的文件或者目录，不包含完整的路径
     public File[] listFiles() ： 获取指定目录下的所有文件或者文件目录的File数组
        -->获取的是指定目录下的文件或者目录，包含完整的路径

     ③：写代码的时候可以先判断是否存在,然后在进行业务逻辑
     public boolean isDirectory()： 判断是否是文件目录
     public boolean isFile() ： 判断是否是文件
     public boolean exists() ： 判断是否存在
     public boolean canRead() ： 判断是否可读
     public boolean canWrite() ： 判断是否可写
     public boolean isHidden() ： 判断是否隐藏

     ④：真正的创建目录或者文件 方法二和三加了s就起飞了~~~
     public boolean createNewFile() ： 创建文件。 若文件存在， 则不创建， 返回false
     public boolean mkdir() ： 创建文件目录。 如果此文件目录存在， 就不创建了。
     如果此文件目录的上层目录不存在， 也不创建。
     public boolean mkdirs() ： 创建文件目录。 如果上层文件目录不存在， 一并创建

     ⑤：public boolean delete()： 删除文件或者文件夹  不走回收站
   6.练习题:
     利用File构造器， new 一个文件目录file
     1)在其中创建多个文件和目录
     2)编写方法，实现删除file中指定文件的操作

     判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称

     遍历指定目录所有文件名称，包括子文件目录中的文件。 --> StudyIO_exer
     拓展1：并计算指定目录占用空间的大小
     拓展2：删除指定文件目录及其下的所有文件
 *
 *
 *
 *
 */
public class StudyIO_1 {

    @Test
    public void test1(){

        //构造器1
        File file1=new File("Hello.txt"); //相对路径 相对于moduel
        File file2=new File("E:\\IntelliJ IDEA\\idea_workspace\\project_01\\module01\\He.txt"); //绝对路径

        //构造器2
        File file3=new File("E:\\IntelliJ IDEA\\idea_workspace","project_01");

        //构造器3
        File file4=new File(file3,"Hi.txt");

        System.out.println(file1);
        System.out.println(file2);
        System.out.println(file3);
        System.out.println(file4);

        //getPath和getAbsolutePath的区别
        System.out.println("11111111111111111");
        String path = file1.getPath();
        String path1 = file1.getAbsolutePath();
        System.out.println(path);
        System.out.println(path1);

        //getName
        String name = file2.getName();
        System.out.println(name);

    }

    @Test
    public void test2(){

        File file=new File("E:\\studytest\\hello.txt");
        File file2=new File("E:\\studytest\\dir1");
        try {
            //创建文件
            boolean newFile = file.createNewFile();
            //创建目录 加了s就暴力起飞
            boolean mkdir = file2.mkdir();
            System.out.println(newFile);
            System.out.println(mkdir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //删除不走回收站
        boolean delete = file.delete();
        System.out.println(delete);

    }



    @Test
    public void test3() throws IOException {

        File file = new File("E:\\studytest\\dir1\\hello.txt");
        boolean newFile = file.createNewFile();
        if(newFile){
            System.out.println("创建成功");
        }else {
            System.out.println("创建失败，文件已经存在");
        }
        File file2 = new File("E:\\studytest\\dir1\\hello1.jpg");
        file2.createNewFile();
        File file13 = new File("E:\\studytest\\dir1");
        String[] list = file13.list();
        for (String s : list) {
            if (s.endsWith("jpg")){
                System.out.println("包含jpg的文件,文件名为"+s);
            }
        }

    }



}
