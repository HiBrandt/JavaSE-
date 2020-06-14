package com.study.java.network;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *网络编程
 *  1.网络编程有两个问题：
 *     -->如何准确的定位网络上的一台或者多台主机;并定位到每台主机上的特定应用？ IP+端口
 *     -->找到主机后如何进行数据传输？ 提供网络通信协议  TCP+
 *  2.  192.168开头的是局域网
 *  3.域名：www.baidu.com www.vip.com ... 就是域名 域名是IP地址的映射，因为ip地址太难记了。和ip地址一一对应
 *  4.流程：输入域名-->DNS服务器解析域名-->将域名解析成IP地址-->通过IP再去定位并且访问
 *  5.端口号与IP地址的组合得出一个网络套接字： Socket
 *  6.InetAdress类   很简单了不写代码了
 *     -->静态方法获取IP实例：  static getLocalHost()  static getByName(String host)
 *     -->String getHostAddress()： 返回 IP 地址字符串
 *     -->String getHostName(): 获取此 IP 地址的主机名
 *     -->boolean isReachable(int timeout)： 测试是否可以达到该地址
 *  7.网络通信协议：-->网络协议：IP协议。  通信传输协议-->TCP/UDP
 *  8.TCP协议：三次握手 四次挥手
 *       使用TCP协议前，须先建立TCP连接，形成传输数据通道
         传输前，采用“三次握手” 方式，点对点通信， 是可靠的
         TCP协议进行通信的两个应用进程：客户端、 服务端。
         在连接中可进行大数据量的传输
         传输完毕，需释放已建立的连接， 效率低
    9.UDP协议：垃圾短信、 看视频
         将数据、源、目的封装成数据包， 不需要建立连接
         每个数据报的大小限制在64K内
         发送不管对方是否准备好，接收方收到也不确认， 故是不可靠的
         可以广播发送
         发送数据结束时无需释放资源，开销小，速度快
    10.TCP协议网络编程：
          ①客户端发送内容给服务端，服务端将内容打印到控制台上  见代码
 *
 *
 *
 */
public class StudyNetWork_1 {

    /**
     * 客户端
     */
    @Test
    public void client()  {

        Socket socket = null;
        OutputStream os = null;

        try {
            //获取IP
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            //因为要访问服务端所以肯定要获取服务端的  socket
             socket = new Socket(ip,8899);

            //获取socket往外写的流  -->原来是通过socket往外写的
            os = socket.getOutputStream();
            os.write("Hello,我是帅哥".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

        //关流
        try {
            if(os != null){
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(socket != null){
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 服务端
     */
    @Test
    public void server()  {


        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            //创建server端的socket 指明接收客户端在哪个端口请求
            serverSocket = new ServerSocket(8899);
            //接收请求
            accept = serverSocket.accept();
            //获取输入流
            inputStream = accept.getInputStream();
            //此时我们设置的快递车足够大，不会出现乱码 但是当设置不够大时就会出现乱码 因为是字节流去读中文字符了
            //不推荐
               //快递车
//            byte [] b = new byte[50];
//            int len;
//            while ((len=inputStream.read(b)) != -1){
//
//                //字节数组转为字符串
//                String s = new String(b, 0, len);
//                System.out.println(s);
//            }

            //推荐
            //读进来多少字节都会用数组自动存起来，写到一个数组里面，并且数组自动扩容
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte [] b = new byte[2];
            int len;
            while ((len=inputStream.read(b)) != -1){
                //字节数组转为字符串
                byteArrayOutputStream.write(b,0,len);
            }
            //将内部数组转为字符串
            String s = byteArrayOutputStream.toString();
            System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //关流
        try {
            if(serverSocket != null){
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(accept != null){
                accept.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(inputStream != null){
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(byteArrayOutputStream != null){
                byteArrayOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
