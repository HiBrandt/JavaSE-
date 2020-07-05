package com.study.java.jdbc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: studyjavaSE
 * @description: 使用连接池和Dbutils 增删改查
 * @author: HiBrandt
 * @create: 2020-07-05 16:19
 **/
public class OperaData2 {

    /**
     * 测试添加
     */
    @Test
    public void testInsert() throws SQLException {

        //获取链接
        Connection connection = JDBCUtilsPool.getConnection();

        String sql = "insert into customers(name,email,birth)values(?,?,?)";

        //QueryRunner  减少代码量 封装了占位符赋值的操作
        //并且已经关闭 PreparedStatement 资源
        QueryRunner queryRunner = new QueryRunner();
        //更新  返回更新的条数
        int i = queryRunner.update(connection, sql, "何成飞", "he@qq.com", "1992-09-08");

        //关闭资源
        JDBCUtilsPool.closeResource(connection,null,null);
    }

    /**
     * 测试查询
     * 查询一条记录 BeanHandler
     */

    @Test
    public void testQueryInstance() throws SQLException {

        //获取数据库连接池,得到链接
        Connection connection = JDBCUtilsPool.getConnection();
        //QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select id,name,email,birth from customers where id = ?";

        // ResultSetHandler 接口的实现类 各种返回形式应有尽有
        // Bean就是一个基础类
        BeanHandler<Customers> beanHandler = new BeanHandler(Customers.class);

        Customers customers = queryRunner.query(connection, sql, beanHandler, 21);

        System.out.println(customers);


    }

    /**
     * 查询多条记录  BeanListHandler
     */
    @Test
    public void  testQueryList() throws SQLException {

        //获取数据库连接池,得到链接
        Connection connection = JDBCUtilsPool.getConnection();
        //QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select id,name,email,birth from customers where id < ?";

        // ResultSetHandler 接口的实现类 各种返回形式应有尽有 可以返回map不是bean的也可以的
        // Bean就是一个基础类
        BeanListHandler<Customers> beanHandler =  new BeanListHandler(Customers.class);

        List<Customers> customersList = queryRunner.query(connection, sql, beanHandler, 10);

        // System.out.println(customersList);

        customersList.forEach(System.out::println);

        //关闭资源
        JDBCUtilsPool.closeResource(connection,null,null);

    }

    /**
     * 查询类似于最大的，最小的，平均的，总和，个数相关的数据  ScalarHandler
     */
    @Test
    public void testQueryValue() throws SQLException {

        //获取数据库连接池,得到链接
        Connection connection = JDBCUtilsPool.getConnection();
        //QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select max(birth) from customers";

        ScalarHandler scalarHandler = new ScalarHandler();


        Date maxBirth =(Date) queryRunner.query(connection, sql, scalarHandler);

        System.out.println(maxBirth);

        //关闭资源
        JDBCUtilsPool.closeResource(connection,null,null);

    }



}
