package com.study.java.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @program: studyjavaSE
 * @description: 数据库连接池技术创建 JDBCUtils 工具类
 * @author: HiBrandt
 * @create: 2020-07-05 15:45
 **/
public class JDBCUtilsPool {


    //提出来是因为不是调一次方法就创建一个池子
    private static DataSource dataSource;

    /**
     * 获取数据库链接
     */
    public static Connection getConnection()  {

        //读取配置文件
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc2.properties");

        //创建读取配置文件流的集合
        Properties pros = new Properties();

        Connection connection = null;
        try {
            //加载配置文件
            pros.load(is);

            //创建连接池
            dataSource = DruidDataSourceFactory.createDataSource(pros);

            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 关闭资源
     * Dbutils的方式
     *
     */

    public static void closeResource(Connection conn, PreparedStatement ps, ResultSet rs){

        //已经后台处理异常了
        DbUtils.closeQuietly(rs);
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(rs);

    }

}
