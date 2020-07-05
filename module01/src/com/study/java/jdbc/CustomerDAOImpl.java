package com.study.java.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @program: studyjavaSE
 * @description: 接口的实现类 实现具体的功能 以便被调用
 * @author: HiBrandt
 * @create: 2020-07-05 18:26
 **/
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {


    @Override
    public void insert(Connection connection, Customers customers) {
        String sql ="insert into customers(name,email,birth)values(?,?,?)";
        super.update(connection,sql,customers.getName(),customers.getEmail(),customers.getBirth());

    }

    @Override
    public void update(Connection connection, Customers customers) {
        String sql ="update customers set name = ?,email = ?,birth = ? where id = ?";
        super.update(connection,sql,customers.getName(),customers.getEmail(),customers.getBirth());
    }

    @Override
    public void deleteById(Connection connection, int id) {
        String sql ="delete from customers where id = ?";
        super.update(connection,sql,id);
    }

    @Override
    public Customers getCustomerById(Connection connection, int id) {
        String sql ="select id,name,email,birth from customers where id = ?";
        Customers customers = super.getInstance(connection, Customers.class, sql, id);
        return customers;
    }

    @Override
    public List<Customers> getAll(Connection connection) {
        String sql ="select id,name,email,birth from customers";
        List<Customers> customersList = super.getForList(connection, Customers.class, sql);
        return customersList;
    }

    @Override
    public Long getCount(Connection connection) {
        String sql ="select count(*) from customers";
        Long count = (Long) super.getValue(connection, sql);
        return count;
    }

    @Override
    public Date getMaxBirth(Connection connection) {
        String sql ="select max(birth) from customers";
        Date date = (Date)super.getValue(connection, sql);
        return date;
    }
}
