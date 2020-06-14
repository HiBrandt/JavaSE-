package com.project.java.project_04;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HdfsOpera {

    public static void main(String[] args) throws IOException {

        //读取文件路径
        String batchpath = Config.BATCHPATH;
        String orderpath = Config.ORDERPATH;

        Batch batch;
        Order order;

        List<Batch> bashList = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();

        //调用读取文件方法
        BufferedReader inBatch = ReadPath(batchpath);
        BufferedReader inOrder = ReadPath(orderpath);


        //批次单放入List
        while (inBatch.ready()) {
            String line = inBatch.readLine();
            String[] arr = line.split(Config.SPLITSTRING);		//将读取的每一行以\001号分割成数组

            if(arr.length!=6) continue;//过滤脏数据
            if(arr[2].equals(0)) continue; //过滤剩余数量为0的批次单

            batch= new Batch();
            batch.setBatchNo(arr[0]);	//批次号
            batch.setBarCode(arr[1]);	//条码
            int i = Integer.parseInt(arr[2]);
            batch.setRemainingNumber(i);	//剩余数量
            batch.setInDate(arr[3]);   //入库时间
            int numCount = Integer.parseInt(arr[4]);
            int maxCount = Integer.parseInt(arr[5]);
            batch.setNumCount(numCount);
            batch.setMaxCount(maxCount);
            bashList.add(batch);			//把从文件中读取的数据存到集合里
        }
        //关闭文件
        inBatch.close();

        //订单放入List
        while (inOrder.ready()){
            String line2 = inOrder.readLine();
            String[] arr2 = line2.split(Config.SPLITSTRING);

            if(arr2.length!=5) continue;//过滤脏数据
            if(arr2[3].equals(0)) continue; //过滤出库数量为0的订单

            order=new Order();
            order.setOrderNO(arr2[0]);
            order.setMarktype(arr2[1]);
            order.setBarcode(arr2[2]);
            int amount = Integer.parseInt(arr2[3]);
            order.setAmount(amount);
            int mark = Integer.parseInt(arr2[4]);
            order.setMark(mark);
            orderList.add(order);
        }
        //关闭文件
        inOrder.close();

        //排序
        bashList = bashList.stream().sorted(Comparator.comparing(Batch::getInDate)).sorted( Comparator.comparing(Batch::getBarCode)).collect(Collectors.toList());

        orderList = orderList.stream().sorted(Comparator.comparing(Order::getMark)).sorted( Comparator.comparing(Order::getBarcode)).collect(Collectors.toList());


        int count=0;//记录写入次数

        File file1 = new File(Config.OUTPUTPATH);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file1));

        //双集合遍历
        for (int i = 0, j = 0; i < bashList.size() && j < orderList.size(); ) {

           // System.out.println(i+"->"+j);

            Batch batch1 = bashList.get(i);
            Order order1 = orderList.get(j);

            int compareFlag = batch1.getBarCode().compareTo(order1.getBarcode());


            if (compareFlag < 0) {
                i++;
            } else if (compareFlag > 0) {
                j++;
            } else {           //匹配上了
                count++;
                StringBuilder Builder = new StringBuilder() ; //写入关联表的字符串
                //剩余数量大于出库数量
                if(batch1.getRemainingNumber() > order1.getAmount()) {
                    //更新批次剩余数量
                    batch1.setRemainingNumber(batch1.getRemainingNumber() - order1.getAmount());

                    //todo write order1.getAmount()
                    if(count==1){
                        StringBuilder append = Builder
                                .append(batch1.getBatchNo()).append(Config.SPLITSTRING)
                                .append(order1.getOrderNO()).append(Config.SPLITSTRING)
                                .append(order1.getMarktype()).append(Config.SPLITSTRING)
                                .append(order1.getAmount()).append(Config.SPLITSTRING)
                                .append(order1.getBarcode());
                        bw.write(append.toString());
                        bw.flush();
                    }else {
                        StringBuilder append = Builder.append("\r\n")
                                .append(batch1.getBatchNo()).append(Config.SPLITSTRING)
                                .append(order1.getOrderNO()).append(Config.SPLITSTRING)
                                .append(order1.getMarktype()).append(Config.SPLITSTRING)
                                .append(order1.getAmount()).append(Config.SPLITSTRING)
                                .append(order1.getBarcode());
                        bw.write(append.toString());
                        bw.flush();
                    }
                    //更新出库数量
                    order1.setAmount(0);
                    j++;    // order向下滑动
                    //等于的情况
                }else if(batch1.getRemainingNumber() == order1.getAmount()){
                    if(count==1){
                        StringBuilder append = Builder
                                .append(batch1.getBatchNo()).append(Config.SPLITSTRING)
                                .append(order1.getOrderNO()).append(Config.SPLITSTRING)
                                .append(order1.getMarktype()).append(Config.SPLITSTRING)
                                .append(order1.getAmount()).append(Config.SPLITSTRING)
                                .append(order1.getBarcode());
                        bw.write(append.toString());
                        bw.flush();
                    }else {
                        StringBuilder append = Builder.append("\r\n")
                                .append(batch1.getBatchNo()).append(Config.SPLITSTRING)
                                .append(order1.getOrderNO()).append(Config.SPLITSTRING)
                                .append(order1.getMarktype()).append(Config.SPLITSTRING)
                                .append(order1.getAmount()).append(Config.SPLITSTRING)
                                .append(order1.getBarcode());
                        bw.write(append.toString());
                        bw.flush();
                    }
                    order1.setAmount(0);
                    batch1.setRemainingNumber(0);
                    //当NumCount和MaxCount不相等的时候才会往下匹配
                    if( batch1.getNumCount()!=batch1.getMaxCount()){
                        i++;
                    }
                    j++;
                }else if(batch1.getRemainingNumber() < order1.getAmount() && batch1.getNumCount()!=batch1.getMaxCount()) {
                    //小于的情况有两种
                    //更新订单出库数量
                    order1.setAmount(order1.getAmount() - batch1.getRemainingNumber());

                    //todo write batch1.setRemainingNumber
                    if(count==1){
                        StringBuilder append = Builder
                                .append(batch1.getBatchNo()).append(Config.SPLITSTRING)
                                .append(order1.getOrderNO()).append(Config.SPLITSTRING)
                                .append(order1.getMarktype()).append(Config.SPLITSTRING)
                                .append(batch1.getRemainingNumber()).append(Config.SPLITSTRING)
                                .append(order1.getBarcode());
                        bw.write(append.toString());
                        bw.flush();
                    }else {
                        StringBuilder append = Builder.append("\r\n")
                                .append(batch1.getBatchNo()).append(Config.SPLITSTRING)
                                .append(order1.getOrderNO()).append(Config.SPLITSTRING)
                                .append(order1.getMarktype()).append(Config.SPLITSTRING)
                                .append(batch1.getRemainingNumber()).append(Config.SPLITSTRING)
                                .append(order1.getBarcode());
                        bw.write(append.toString());
                        bw.flush();
                    }
                    //批次剩余数量为0
                    batch1.setRemainingNumber(0);
                    i++;
                }else if(batch1.getRemainingNumber() < order1.getAmount() && batch1.getNumCount()==batch1.getMaxCount()) {
                    if(count==1){
                        StringBuilder append = Builder
                                .append(batch1.getBatchNo()).append(Config.SPLITSTRING)
                                .append(order1.getOrderNO()).append(Config.SPLITSTRING)
                                .append(order1.getMarktype()).append(Config.SPLITSTRING)
                                .append(order1.getAmount()).append(Config.SPLITSTRING)
                                .append(order1.getBarcode());
                        bw.write(append.toString());
                        bw.flush();
                    }else {
                        StringBuilder append = Builder.append("\r\n")
                                .append(batch1.getBatchNo()).append(Config.SPLITSTRING)
                                .append(order1.getOrderNO()).append(Config.SPLITSTRING)
                                .append(order1.getMarktype()).append(Config.SPLITSTRING)
                                .append(order1.getAmount()).append(Config.SPLITSTRING)
                                .append(order1.getBarcode());
                        bw.write(append.toString());
                        bw.flush();
                    }
                    batch1.setRemainingNumber(batch1.getRemainingNumber()-order1.getAmount());
                    order1.setAmount(0);
                    j++;
                }
            }
        }
        bw.close();
    }


    /**
     * 读取文件路径并返回BufferedReader
     * @param path
     * @return
     * @throws IOException
     */
     public static BufferedReader ReadPath(String path) throws IOException {

         // 10M缓存
         BufferedInputStream buffInput = new BufferedInputStream(new FileInputStream(new File(path)));
         BufferedReader buffRead = new BufferedReader(new InputStreamReader(buffInput, "UTF-8"), 10 * 1024 * 1024);
         return  buffRead;
     }



}
