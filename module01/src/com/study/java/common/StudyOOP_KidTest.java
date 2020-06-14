package com.study.java.common;

public class StudyOOP_KidTest {

    public static void main(String[] args) {
        Kids kids=new Kids();
        kids.yearsold=18;
        //调用父类的属性和方法 如果父类的是private的不能直接调用
        kids.sex=1;
        kids.manOrWoman();

        kids.printAge();

        //调用重写的方法
        kids.employeed();

    }

}

class ManKind{
     int sex;

     int salary;

   public void manOrWoman(){
        if(sex==1){
            System.out.println("man");
        }else {
            System.out.println("woman");
        }
   }

    public void employeed(){
        if(salary==0){
            System.out.println("nojob");
        }else {
            System.out.println("job");
        }
    }
}

class Kids extends ManKind{

     int yearsold;

    public void printAge(){
        System.out.println(yearsold);
    }

    //重写父类的方法
    public void employeed(){
        System.out.println("应该去学习而不是工作");
    }

}
