package com.study.java.jdbc;

import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Mysql数据通用的增删改查方法
 */
public class OperaData {

    public void update(String sql,Object... args)  {

        //获取数据库链接
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement ps = null;

        try {
            //获取sql预编译执行对象
            ps = connection.prepareStatement(sql);

            for(int i = 0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtils.closeResource(ps,connection);

    }

    /**
     * 测试更新数据
     */
    @Test
    public void test1(){
        String sql ="update customers set birth=? where id=?";
        try {
            update(sql,"1987-06-12","3");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 针对一张表通用的查询数据
     */
    public void select(String sql,Object... args)  {

        Connection connection = JDBCUtils.getConnection();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);

            for (int i =0;i<args.length;i++){

                ps.setObject(i+1,args[i]);
            }

            //获取结果集 封装的查询的结果
            ResultSet resultSet = ps.executeQuery();
            //获取结果集中的元数据 里面包含数据列的列数
            ResultSetMetaData data = resultSet.getMetaData();
            int columnCount = data.getColumnCount(); //结果集包含的列数

            while (resultSet.next()){
                for(int j =0;j<columnCount;j++){
                    System.out.println(resultSet.getObject(j+1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtils.closeResource(ps,connection);

    }

    /**
     * 测试一张表查询数据
     */
    @Test
    public void test2(){

       String sql="select id,name,email from customers where id>=?";
       select(sql,"1");
    }

    /**
     * 针对多张表的通用的查询
     *   反射/别名/泛型
     *  不知道传什么类就用泛型
     *  不知道占位符有几个就用可变形参
     *  返回值类型我也不知道是啥 就是返回一个泛型
     */

    public <T> T  select2(Class<T> clazz,String sql,Object ... args) {

        Connection connection = JDBCUtils.getConnection();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);


            //占位符赋值
            for(int j = 0;j<args.length;j++){
                ps.setObject(j+1,args[j]);

            }
            //执行查询的语句
            ResultSet resultSet = ps.executeQuery();

            //获取结果集元数据
            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount(); //获取数据库表的列数

            while (resultSet.next()){

                //反射获取运行时类的对象
                //第一次写放入for循环里面了
                T t = clazz.newInstance();
                for(int i = 0;i<columnCount;i++){

                    String columnName = metaData.getColumnLabel(i + 1);
                    //根据别名获取列的值
                    // todo 可能有bug 就换成根据顺序获取
                    Object object = resultSet.getObject(columnName);

                    //反射指定给哪个列赋值
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    //反射指定给哪个对象赋值
                    field.set(t,object);
                }
                //return的地方第一次写错了
                return t;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(ps,connection);
        }

        //不进 if就返回null
        return null;
    }


    /**
     * 测试 通用的查询
     */
    @Test
    public void test4(){

        String sql = "select id,name,email,birth from customers where id =?";

        Customers customers = select2(Customers.class, sql, 1);

        System.out.println(customers);

        // order是关键字 用反引号 ``
        String sql2 = "select order_id orderID,order_name orderName,order_date orderDate from `order` where order_id =?";

        Order order = select2(Order.class, sql2, 1);

        System.out.println(order);


    }

    /**
     * 通用的查询多跳记录的方法
     *
     */

    public <T>List select3(Class<T> clazz,String sql,Object ...args){

        //装返回查询结果的对象
        List<T> list = new ArrayList();

        Connection connection = JDBCUtils.getConnection();

        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);


            //占位符赋值
            for(int j = 0;j<args.length;j++){
                ps.setObject(j+1,args[j]);

            }
            //执行查询的语句
            ResultSet resultSet = ps.executeQuery();

            //获取结果集元数据
            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount(); //获取数据库表的列数

            while (resultSet.next()){

                //反射获取运行时类的对象
                //第一次写放入for循环里面了
                T t = clazz.newInstance();
                for(int i = 0;i<columnCount;i++){

                    String columnName = metaData.getColumnLabel(i + 1);
                    //根据别名获取列的值
                    // todo 可能有bug 就换成根据顺序获取
                    Object object = resultSet.getObject(columnName);

                    //反射指定给哪个列赋值
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    //反射指定给哪个对象赋值
                    field.set(t,object);
                }
               list.add(t);

            }
           return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(ps,connection);
        }

        return  null;
    }

    /**
     * 测试通用返回多条查询结果的方法
     */
    @Test
    public void test5(){

        String sql = "select id,name,email,birth from customers where id >=?";
        List list = select3(Customers.class, sql, 1);

        for (Object o : list) {
            System.out.println(o);
        }
    }

    /**
     * 插入blob数据
     *
     */

    @Test
    public void insetblob()  {
        Connection connection = JDBCUtils.getConnection();
        String sql ="insert into customers(name,email,birth,photo)values(?,?,?,?)";
        PreparedStatement ps = null;
        FileInputStream fis = null;
        try {
            ps = connection.prepareStatement(sql);

            ps.setObject(1,"古力娜扎");
            ps.setObject(2,"nazha@qq.com");
            ps.setObject(3,new Date(new java.util.Date().getTime()));

            fis = new FileInputStream("E:\\studytest\\timg.jpg");
            // 要求传入的是IO流
            ps.setBlob(4,fis);
            ps.execute();


        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            try {
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JDBCUtils.closeResource(ps,connection);


    }

    /**
     * 读取blob数据
     *
     */

    @Test
    public void readbolb() throws SQLException, IOException {

        String sql = "SELECT id, name, email, birth, photo FROM customers WHERE id = ?";
        InputStream is = null;
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, 20);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            Integer id = rs.getInt(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            Date birth = rs.getDate(4);
            Customers cust = new Customers(id, name, email, birth);
            System.out.println(cust);
            //读取Blob类型的字段
            Blob photo = rs.getBlob(5);
             is = photo.getBinaryStream();
            OutputStream os = new FileOutputStream("E:\\studytest\\timg2.jpg");
            byte [] buffer = new byte[1024];
            int len = 0;
            while((len = is.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }
            JDBCUtils.closeResource(ps,conn);

            if(is != null){
                is.close();
            }

            if(os !=  null){
                os.close();
            }

        }
    }


    /**
     * 执行≠提交
     * 最高效的批量添加数据操作（终极方法）
     * 关闭自动提交后执行execute就不提交了 以前没开启是自动提交的
     * 关闭自动提交后 是等所有的sql都准备好了，一次性提交
     * 之前的批量提交是 ps.executeBatch(); 500执行一次提交攒数据
     *
     * 最垃圾的是执行10000次，加了批量后是执行 10000/500次 在加上关闭自动提交是执行一次
     *
     */

    public void insertbatch() throws SQLException {

        String sql = "insert into goods(name)values(?)";
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);

        //开启事务 关闭自动提交
        connection.setAutoCommit(false);

        for(int i =0;i<=10000;i++){
            ps.setObject(1,"name"+i);

                //攒数据
                ps.addBatch();

                if( i % 500 == 0){
                    //到500作为一个提交批次
                    ps.executeBatch();
                    //清空批次
                    ps.clearBatch();

                }

        }
        //提交数据
        connection.commit();


        JDBCUtils.closeResource(ps,connection);



    }

    /**
     *
     * 模拟关闭自动提交  并且只使用一个连接
     * 事务
     * Connection connection 需要作为参数了 是需要一个连接穿起来
     */
    public void update2(Connection connection, String sql,Object...args){

        PreparedStatement ps = null;

        try {
            //获取sql预编译执行对象
            ps = connection.prepareStatement(sql);

            for(int i = 0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //因为是需要事务  不能关闭连接 不然就自动提交了
        JDBCUtils.closeResource(ps,null);
    }

    @Test
    public void test6()   {

        Connection connection = JDBCUtils.getConnection();
        try {
            //关闭自动提交
            connection.setAutoCommit(false);


            //connection.setTransactionIsolation(); 设置数据库隔离界别

            String sql="update user_table set balance = balance - 100 where user = ?";


            //用的是同一个连接哈
            update2(connection,sql,"AA");

            System.out.println(100/0);

            String sql2 = "update user_table set balance = balance + 100 where user = ?";

            update2(connection,sql2,"BB");

            //提交
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //如果出现异常就回滚
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            //在关闭前需要把连接再设置成自动提交，借的是啥样 还回去也得是啥样
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(null,connection);

        }



    }


}


