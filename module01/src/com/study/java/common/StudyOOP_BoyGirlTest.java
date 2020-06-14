package com.study.java.common;

public class StudyOOP_BoyGirlTest {

    public static void main(String[] args) {

        Boy boy=new Boy();
        boy.setAge(23);
        boy.setName("罗密欧");
        Girl girl =new Girl();
        girl.setName("朱丽叶");
        girl.setAge(20);
        girl.marry(boy);

        int compare1 = girl.compare(girl);
        System.out.println(compare1);

        Girl girl2 =new Girl();
        girl2.setAge(22);
        int compare2 = girl.compare(girl2);
        System.out.println(compare2);
    }
}

class Boy{
    private String name;
    private int age;



    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void marry(Girl girl){
        System.out.println("我想娶:"+girl.getName());
    }

    public void shout(int age){
        this.age=age;
        if(age<0 && age>120) {
            System.out.println("年龄不合法");
        }else if (age >= 22) {
            System.out.println("可以结婚了");
        }else{
            System.out.println("还不到结婚的年龄");
            }
        }
    }


class Girl{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void marry(Boy boy){
        System.out.println("我想嫁给:"+boy.getName());
        //这里的this代表当前对象。谁调用女孩的marry方法 这个this就是谁
        // 参数千万不要写new Girl，不然就是两个对象了 不是最初的那个调用marry的对象
        //不能娶多个啊 哈哈哈~~
        boy.marry(this); // boy回应
    }

    public int compare(Girl girl){
        // this代表的是调用compare方法的女孩
        // 参数是传进来的另外一个 也可以自己和自己比较这样此时没啥意思
        return this.age-girl.age;
    }
}
