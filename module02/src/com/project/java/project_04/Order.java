package com.project.java.project_04;

public class Order    {


    private String orderNO;//订单号

    private String marktype;//订单类型

    private String barcode;//条码

    private int  amount; //数量

    private int mark; //标记

    //记得换


    public Order(String orderNO, String marktype, String barcode, int amount, int mark) {
        this.orderNO = orderNO;
        this.marktype = marktype;
        this.barcode = barcode;
        this.amount = amount;
        this.mark = mark;
    }

    public Order() {
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }


    public String getOrderNO() {
        return orderNO;
    }

    public void setOrderNO(String orderNO) {
        this.orderNO = orderNO;
    }

    public String getMarktype() {
        return marktype;
    }

    public void setMarktype(String marktype) {
        this.marktype = marktype;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNO='" + orderNO + '\'' +
                ", marktype='" + marktype + '\'' +
                ", barcode='" + barcode + '\'' +
                ", amount=" + amount +
                ", mark=" + mark +
                '}';
    }

//    @Override
//    public int compareTo(Order o) {
//        return this.mark-o.mark;
//    }
}
