package com.study.java.network;

import org.testng.annotations.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *10.TCP协议网络编程：-->从Socket出来的流都是用来接收和发送的
 *  ②从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接
 *
 *  //很重要 告诉服务端发完了  不然会一直阻塞
       socket.shutdownOutput();
 *
 */
public class StudyNetWork_exer {


    /**
     * 客户端
     */
    @Test
    public void client() {

        //定义socket
        Socket socket = null;
        //定义输入流
        FileInputStream fileInputStream = null;
        //定义输出流
        OutputStream outputStream = null;
        //定义接收服务端过来的流
        InputStream inputStream = null;
        //自由伸缩的流
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            socket = new Socket("127.0.0.1",8090);
            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream(new File("E:\\studytest\\dir2\\idea_workspace\\timg.jpg"));

            //快递车
            byte [] b = new byte[1024];
            int len;
            while ((len = fileInputStream.read(b)) != -1){

                outputStream.write(b,0,len);
            }

            //很重要 告诉服务端发完了  不然会一直阻塞
            socket.shutdownOutput();

            //todo 接受客户端发过来的
            inputStream = socket.getInputStream();

            byteArrayOutputStream = new ByteArrayOutputStream();

            int len3 ;
            while ((len3 = inputStream.read(b)) != -1){
                byteArrayOutputStream.write(b,0,len3);
            }

            //输出自由伸缩的流
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关流
            try {
                if(fileInputStream != null){
                    fileInputStream.close();
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

            try {
                if(outputStream != null){
                    outputStream.close();
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

            try {
                if(inputStream != null){
                   inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    /**
     * 服务端
     */
    @Test
    public void server()  {

        ServerSocket serverSocket = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;
        Socket accept = null;
        try {
            serverSocket = new ServerSocket(8090);

            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            fileOutputStream = new FileOutputStream("E:\\studytest\\dir2\\idea_workspace\\timg2.jpg");

            byte [] b = new byte[1024];
            int len1 ;
            while ((len1 = inputStream.read(b)) != -1){

                fileOutputStream.write(b,0,len1);
            }

            //返回给客户端
            outputStream = accept.getOutputStream();
            outputStream.write("我已经将你发送的图片保存在本地".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }





    }
}
