package com.study.java.jdbc;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBCUtils
 * 提供获取链接、关闭资源的类
 */
public class JDBCUtils {

    /**
     * 加载Mysql驱动
     * @return connection链接
     */

    public static Connection getConnection(){


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
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                resourceAsStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

          return connection;
    }

    /**
     *  关闭资源
     * @param ps   PreparedStatement 预编译
     * @param conn Connection  数据库链接
     * @param is   InputStream  输入流
     */

    public static void closeResource(PreparedStatement ps,Connection conn){

        try {
            if(ps != null){

                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static void closeResource(PreparedStatement ps, Connection conn, ResultSet rs){

        try {
            if(ps != null){

                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
