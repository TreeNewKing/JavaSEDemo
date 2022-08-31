package com.se.network.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class demo_5 {

    public static void main(String[] args) throws IOException {
//        demo1();
//        demo2();
    demo3();
    }

    /**
     * 简易连接baidu
     * @throws IOException
     */
    public static void demo1() throws IOException {
        URL url=new URL("https://www.baidu.com");
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        InputStream inputStream = urlConnection.getInputStream();
        Scanner scanner=new Scanner(inputStream, String.valueOf(StandardCharsets.UTF_8));
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }

    /**
     * 请求头和响应头的查看设置
     * @throws IOException
     */
    public static void demo2() throws IOException {
            URL url=new URL("https://www.baidu.com");
            URLConnection urlConnection = url.openConnection();
//            设置请求头
            urlConnection.setDoOutput(true);//打开后可向服务器输出
        urlConnection.setConnectTimeout(1000);
//请求头只能通过get方法获得
        System.out.println("连接超时时间"+urlConnection.getConnectTimeout());
//开始连接
        urlConnection.connect();
//获取响应头和响应行
        Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//        打印
        headerFields.forEach((s, strings) ->{
            System.out.println(s+strings);
        } );
    }
/**
 * 表单使用
 */
public static  void demo3() throws UnsupportedEncodingException {
//    特殊字符全部转化成十六进制的utf-8编码，空格编码
    String encode = URLEncoder.encode("www.baidu.com?querty1=I am your 爸爸.", String.valueOf(StandardCharsets.UTF_8));
    System.out.println(encode);
}
}

