package com.study.java.jdbc;

import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * JDBC：（Java Database Connectivity）一组API接口 （属于java语言。在java.sql下）（原来我们经常倒的jar包其实只是驱动）
 *   -->上连java，下连各种数据库的驱动。（驱动就是接口的实现类）
 * 面向接口编程
 *
 * Statement会引起sql注入，（where 1=1;）用他的子接口 PreparedStatement
 *   -->PreparedStatement 提高代码的可读性 一条预编译过的 SQL 语句 防止sql注入
 *   -->预编译加占位符可以防止sql注入
 *
 * 当我们的java类的属性名称和数据库字段的名称不一致时，sql语句可以写成带别名的形式，给字段起别名
 * 然后调用 getColumnLabel(int column)：获取指定列的别名 去用反射给类的属性赋值  --> OperaData
 *
 * sql语句遇到关键字要用反引号``
 *
 * Blob的插入和读取
 * 批量插入
 *
 * 数据一旦提交就不能回滚了 所以有的时候要关闭自动提交
 * **关闭数据库连接，数据就会自动的提交。
 * **如果多个操作，每个操作使用的是自己单独的连接，则无法保证事务。即同一个事务的多个操作必须在同一个连接下。
 *
 * 所以为了满足事务 必须满足 两个条件：①关闭自动提交 ②保证是在同一个连接下
 *
 * //在关闭前需要把连接再设置成自动提交，借的是啥样 还回去也得是啥样  connection.setAutoCommit(true);
 *
 * connection.setTransactionIsolation(); 设置数据库事务的隔离级别
 *
 * 连接池的好处：
 *   -->资源重用 避免频繁的创建
 *   -->提升反应速度
 *   -->统一管理  可以避免内存泄漏 （就是没有及时回收资源）
 *
 *  DbUtils 阿帕奇的数据库增删改查工具
 *
 *  变为抽象类的另外一个好处就是有点"暗示强制"重写的意味 比如BaseDAO
 *
 *    感悟：因为BaseDAO是适用于所有类的数据库增删改查的类，不需要new对象，因为是针对所有的所以必须要重写就声明为一个抽象类
 *      -->此外接口定义的是规范 是指的是这对某个类都可以操作什么东西
 *      -->接口的实现类具体实现接口定义的抽象方法
 *    宏观(适用于所有)-->针对于某个类的操作规范(接口)-->根据规范具体实现功能(实现类)-->调用实现类的方法  （层层递进）
 *      抽象类更像是功能/属性  接口更像是规范
 *
 * 可变形参可以传多个也可以不传
 *
 *
 */
public class JDBC_1 {


    /**
     * 获取数据库链接
     * 不太好 数据库链接信息都明文暴露了
     */
    @Test
    public  void  test1() throws Exception {

        //三要素
        String user="root";
        String password="root";
        String url="jdbc:mysql://localhost:3306/test";
        //反射加载
        //Driver中静态代码块，随着类的加载就完成了Mysql驱动的注册
        Class.forName("com.mysql.jdbc.Driver");

//        static {
//            try {
//                DriverManager.registerDriver(new Driver());
//            } catch (SQLException var1) {
//                throw new RuntimeException("Can't register driver!");
//            }
//        }


        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);

        //关闭资源
        connection.close();



    }

    /**
     * 加载Driver正确的写法
     *   防止明文 不用修改代码 只需修改配置文件 不用重新打包
     */
    @Test
    public void test2() throws IOException, ClassNotFoundException, SQLException {

        //默认就是src下的目录
        InputStream resourceAsStream = JDBC_1.class.getClassLoader().getResourceAsStream("jdbc.properties");

        //读取配置文件
        Properties ps = new Properties();
        ps.load(resourceAsStream);

        //拿到配置文件的信息
        String user = ps.getProperty("user");
        String password = ps.getProperty("password");
        String url = ps.getProperty("url");
        String driverClass = ps.getProperty("driverClass");

        Class.forName(driverClass);//加载Mysql驱动

        Connection connection = DriverManager.getConnection(url,user,password);
        System.out.println(connection);

        //关闭资源
        connection.close();
        resourceAsStream.close();


    }


    /**
     * PreparedStatement 向数据库添加操作
     */
    @Test
    public void test3() {
        //默认就是src下的目录
        InputStream resourceAsStream = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            resourceAsStream = JDBC_1.class.getClassLoader().getResourceAsStream("jdbc.properties");

            //读取配置文件
            Properties ps = new Properties();
            ps.load(resourceAsStream);

            //拿到配置文件的信息
            String user = ps.getProperty("user");
            String password = ps.getProperty("password");
            String url = ps.getProperty("url");
            String driverClass = ps.getProperty("driverClass");

            Class.forName(driverClass);//加载Mysql驱动

            connection = DriverManager.getConnection(url,user,password);

            String sql = "insert into customers (name,email,birth) values (?,?,?)"; //占位符
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,"阿巴阿巴");
            preparedStatement.setString(2,"abaab@qq.com");

            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = sd.parse("2020-07-01 23:32:43");
            long time = date.getTime();
            preparedStatement.setDate(3, new java.sql.Date(time));

            //执行
            preparedStatement.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if(preparedStatement != null){
                preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection!=null){
                connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(resourceAsStream != null){
                resourceAsStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }





    }


}
