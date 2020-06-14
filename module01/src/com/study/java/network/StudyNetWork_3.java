package com.study.java.network;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * URL网络编程
 *
 * public String getProtocol( ) 获取该URL的协议名
   public String getHost( ) 获取该URL的主机名
   public String getPort( ) 获取该URL的端口号
   public String getPath( ) 获取该URL的文件路径
   public String getFile( ) 获取该URL的文件名
   public String getQuery( ) 获取该URL的查询名
 *
 *
 */
public class StudyNetWork_3 {

    public static void main(String[] args)  {

        //获取URL对象
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL("https://588ku.com/ycpng/12848620.html");
            //获取链接对象
            urlConnection = (HttpURLConnection) url.openConnection();
            //获取链接
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            fileOutputStream = new FileOutputStream(new File("E:\\studytest\\dir2\\idea_workspace\\aa.html"));

            byte [] b = new byte[1024];
            int len;

            while ((len = inputStream.read(b)) != -1){
                 fileOutputStream.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //关流
            try {
                if(fileOutputStream != null){
                    fileOutputStream.close();
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

            //关闭连接
            if(urlConnection != null){
                urlConnection.disconnect();
            }

        }





    }
}
