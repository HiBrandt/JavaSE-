package com.study.java.io;

import org.testng.annotations.Test;

import java.io.*;

/**
 *
 * IO流-->对象流（处理流的一种）代码演示
 *    -->ObjectInputStream和OjbectOutputSteam
 *    -->用于存储和读取基本数据类型数据或对象的处理流,把Java中的对象写入到数据源中，也能把对象从数据源中还原回来
 * 1.序列化：把对象保存到磁盘或者其他网络节点
 *   反序列化：把已经存到磁盘或者其他网络节点的java对象，再读入到内存之中
 * 2.注意事项：
 *   ①-->要想实现序列化必须实现Serializable接口
 *   ②-->static和transient修饰的成员变量不能被序列化
 *   ③-->***必须显示声明一个UID的静态常量属性（版本控制）   private static final long serialVersionUID
 *   ④-->***要想类可以序列化，必须保证类的属性也必须可以序列化。
 *           基本类型和String是可以的，如果是自定义的属性，该自定义类也必须实现Serializable接口并显示声明UID
 *   ⑤-->注意写出一次，操作flush()一次
 * 3.关于版本号的说明：
 *    -->在反序列化的时候，JVM会把读取进来的字节流中serialVersionUID与本地相应实体类的serialVersionUID进行比较
 *       如果如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
 *    -->***即便是你的类在序列化之后做了修改，只要是版本号没有发生改变，那么就可以反序列化成功
 * 4.阿帕奇提供了封装好的关于IO流的API,开发中直接用。真省事，哈哈哈。但是底层也是IO流写的
 *
 *
 */
public class StudyIO_6  {


    /**
     * OjbectOutputSteam 序列化
     */
    @Test
    public void test1(){

        //造节点流
        FileOutputStream fileOutputStream = null;
        //造处理流
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(new File("E:\\studytest\\dir1\\test3.bat"));
            //套接
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            //写对象
            objectOutputStream.writeObject(new Person("小白",20,80));
            //flush
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //关流
        try {
            if(objectOutputStream != null){
                objectOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * ObjectInputStream 反序列化
     *
     */

    @Test
    public void test2(){
        //造流
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInput = null;

        try {
            fileInputStream = new FileInputStream("E:\\studytest\\dir1\\test3.bat");//要读的文件
            objectInput = new ObjectInputStream(fileInputStream);

            Object o = objectInput.readObject(); //读取对象
            Person person = (Person) o;
            System.out.println(person.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            if(objectInput != null){
                objectInput.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class Person implements Serializable{

    private static final long serialVersionUID = 3213123312L;
    private String name;
    private int age;
    private int score;

    public Person(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
