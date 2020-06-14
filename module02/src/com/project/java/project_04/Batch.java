package com.project.java.project_04;

import java.text.SimpleDateFormat;

public class Batch  {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String batchNo; //批次号

    private String barCode; //条码

    private int remainingNumber; //剩余数量

    private String inDate;

    private int numCount; //当前排第几

    private int maxCount;//barcode最大数值



    // 空参
    public Batch() {

    }

    //有参
    public Batch(String batchNo, String barCode, int remainingNumber, String inDate, int numCount, int maxCount) {
        this.batchNo = batchNo;
        this.barCode = barCode;
        this.remainingNumber = remainingNumber;
        this.inDate = inDate;
        this.numCount = numCount;
        this.maxCount = maxCount;
    }


    public String getBatchNo() {
        return batchNo;
    }

    public String getBarCode() {
        return barCode;
    }

    public int getRemainingNumber() {
        return remainingNumber;
    }

    public String getInDate() {
        return inDate;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void setRemainingNumber(int remainingNumber) {
        this.remainingNumber = remainingNumber;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public int getNumCount() {
        return numCount;
    }

    public void setNumCount(int numCount) {
        this.numCount = numCount;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "batchNo='" + batchNo + '\'' +
                ", barCode='" + barCode + '\'' +
                ", remainingNumber=" + remainingNumber +
                ", inDate='" + inDate + '\'' +
                ", numCount=" + numCount +
                ", maxCount=" + maxCount +
                '}';
    }

    //    @Override
//    public int compareTo(Batch b) {
//        long time=0L;
//        long time2 = 0L;
//        try {
//             time = sdf.parse(this.inDate).getTime();
//             time2 = sdf.parse(b.inDate).getTime();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return (int) (time-time2);
//    }
}
