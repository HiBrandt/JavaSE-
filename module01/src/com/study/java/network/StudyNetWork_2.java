package com.study.java.network;



import org.testng.annotations.Test;

import java.io.IOException;
import java.net.*;

/**
 *
 * UDP网络编程：不管收不收到，我只发了就行  高效  不可靠
 *   -->就算先启动发送端也没事（不像TCP必须先启动服务端，不然报错），但是也接收不到了
 */
public class StudyNetWork_2 {

    /**
     * 发送端
     */
    @Test
    public void sender() throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket();

        //准备发送的数据
        String str = "我是洲际导弹";
        byte[] bytes = str.getBytes();

        InetAddress localHost = InetAddress.getLocalHost();

        //打包数据
        DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,localHost,8822);
        //发送数据
        datagramSocket.send(datagramPacket);

        //关闭
        datagramSocket.close();

    }

    /**
     * 接收端
     */

    @Test
    public void server() throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket(8822);

        byte [] buffer = new byte[100];

        //接收到了数据
        DatagramPacket datagramPacket = new DatagramPacket(buffer,0,buffer.length);

        datagramSocket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));

        datagramSocket.close();
    }
}
