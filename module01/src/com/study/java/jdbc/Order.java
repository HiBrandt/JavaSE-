package com.study.java.jdbc;

import java.util.Date;

/**
 * @author HiBrandt
 * @date 2020/7/4 10:18
 *
 * 表order 映射类
 */
public class Order {

    //属性名称和数据库字段不一致哦
    private int orderID;
    private String orderName;
    private Date orderDate;

    public Order(int orderID, String orderName, Date orderDate) {
        this.orderID = orderID;
        this.orderName = orderName;
        this.orderDate = orderDate;
    }

    public Order() {
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", orderName='" + orderName + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}
