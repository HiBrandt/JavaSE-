package com.study.java.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * @program: studyjavaSE
 * @description: 这是针对于Customer类映射数据库的增删改查的规范
 * @author: HiBrandt
 * @create: 2020-07-05 17:59
 **/
public interface CustomerDAO {

    /**
     * 插入
     */
    void insert(Connection connection,Customers customers);

    /**
     * 更新(其实传ID也是可以的)
     */
    void update(Connection connection,Customers customers);

    /**
     * 删除
     */
    void deleteById(Connection connection,int id);

    /**
     * 根据ID获取指定的对象
     */
    Customers getCustomerById(Connection connection,int id);

    /**
     *获取多个对象
     */
    List<Customers> getAll(Connection connection);

    /**
     * 获取特殊值：返回count
     */

    Long getCount(Connection connection);

    /**
     * 获取特殊值：返回最大生日
     */
    Date getMaxBirth(Connection connection);

}
