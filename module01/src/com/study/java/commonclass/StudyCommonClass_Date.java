package com.study.java.commonclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * 1.System.currentTimeMillis()返回1970年1月1日0时0分0秒 时间戳
 * 2. Date date=new Date(); System.out.println(date); -->Sun Apr 19 15:51:57 CST 2020 本地当前时间
 *      -->System.out.println(date.getTime()); 也是时间戳
 * 3. java.sql.Date是Date的子类
 *      -->java.sql.Date sqldate=new java.sql.Date(date.getTime()); Date转为sqldate--> 2020-04-19
 * 4.复习：子类转化为父类类型（多态） 父类转化为子类 强转 instanceof
 * 5.SimpleDateFormat 一个是解析一个是格式化 SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
 *   转化为啥形式后面参数就写啥形式
 *     ①格式化-->把Date转化为字符串  sdf1.format(date);
 *     ②解析-->把字符串转化为Date  sdf1.parse("xxxxx"); 参数不能乱写，否则抛异常
 *
 * 6.日历类 太懒了不想写了
 * 7.据说JDK8之后的时间格式API比较好用
 *     -->LocalDate、 LocalTime、 LocalDateTime -->看下面的timetest方法
 *     LocalDateTime最常用
 * 8. DateTimeFormatter 垃圾不好用
 *
 *
 */
public class StudyCommonClass_Date {

    public static void main(String[] args) throws ParseException {


        System.out.println(System.currentTimeMillis());

        Date date=new Date(); System.out.println(date); //Sun Apr 19 15:51:57 CST 2020
        System.out.println(date.getTime());

        Date date2=new Date(date.getTime());
        System.out.println(date2.toString()); //Sun Apr 19 15:51:57 CST 2020

        java.sql.Date sqldate=new java.sql.Date(date.getTime());
        System.out.println(sqldate); //2020-04-19



        //SimpleDateFormat
        System.out.println("----------------------------------------------------------");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String format = sdf1.format(date);
        System.out.println(format);

        Date parse = sdf1.parse("2019-04-21 09:36:02");
        System.out.println(parse);

        //将"2020-04-12"转化为sqldate
        SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd"); //怕和分重合 月就大写

        Date date1 = sdf2.parse("2020-04-12");

        java.sql.Date sqldate2=new java.sql.Date(date1.getTime());

        System.out.println(sqldate2);

        datetest();
        timetest();

    }


    /**
     * 三天打鱼两天晒网 从1990-01-01开始  到将来的某个时间是打鱼还是晒网
     */
    public static void datetest() throws ParseException {

        SimpleDateFormat sdf3=new SimpleDateFormat("yyyy-MM-dd");
        //将来的时间
        String strWill="1994-10-29";
        Date will = sdf3.parse(strWill); //将来时间

        long time = will.getTime();

        String strAgo="1990-01-01";
        Date ago = sdf3.parse(strAgo);  //过去的时间

        long time1 = ago.getTime();

        long l = (time - time1) / (1000*60*60*24) ;
        System.out.println("天数为:"+l);

        long l1 = l % 5;
        if(l1>3 || l1==0){  //忘记加==0了
            System.out.println("晒网");
        }else {
            System.out.println("打鱼");
        }


    }

    /**
     *
     * LocalDate localtime  localDatetime
     */
    public static void timetest(){

        System.out.println("----------------------------------------------");

        //获取当前的时间日期
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //获取指定时间日期
        LocalDateTime of = LocalDateTime.of(2020, 03, 21, 22, 50, 00);
        System.out.println(of);
        //获取相关属性
        System.out.println(localDateTime.getMonth());
        int monthValue = localDateTime.getMonthValue();
        System.out.println(monthValue);
        int dayOfMonth = localDateTime.getDayOfMonth();
        System.out.println(dayOfMonth);
        //设置相关属性 返回的是新的对象 体现不可变性with
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime1);
        //加减
        LocalDateTime localDateTime2 = localDateTime.plusHours(2);
        System.out.println(localDateTime2);
        LocalDateTime localDateTime3 = localDateTime.minusMonths(2);
        System.out.println(localDateTime3);





    }
}
