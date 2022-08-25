package com.se.network.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class demo_1 {
    public static void main(String[] args) throws IOException {
//test_1()
//test_2();
        test_3();
    }
/**
 *使用构造方法建立socket
 *
 */
    public static   void test_1() throws IOException {
        Socket socket = new Socket("time-a.nist.gov",13);//创建套接字
//        todo Scanner对象的使用
        Scanner scanner = new Scanner(socket.getInputStream(), String.valueOf(StandardCharsets.UTF_8));
        while (scanner.hasNextLine()){
            String line=scanner.nextLine();
            System.out.println(line);
            socket.close();
        }
    }

    /**
     * 使用构造方法建立套接字并设置超时时间
     * @throws IOException
     *  fixme 如果不断开连接。有时会读不到数据也不会抛出超时异常这是为啥呢？
     */
    public  static  void  test_2() throws IOException {
        Socket socket=new Socket("time-a.nist.gov",13);
        socket.setSoTimeout(3000);
        Scanner scanner = new Scanner(socket.getInputStream(), String.valueOf(StandardCharsets.UTF_8));
        try {
        while (scanner.hasNextLine()){
            String line=scanner.nextLine();
            System.out.println(line);
            socket.close();
        }
        }catch (Exception e){
            System.out.println("超时了");
        }
    }

    /**
     * 建立空套接子后连接
     * @throws IOException
     */
    public  static  void test_3()  {
        Socket socket=new Socket();
        try {
        socket.connect(new InetSocketAddress("time-a.nist.gov",13),30);
        Scanner scanner = new Scanner(socket.getInputStream(), String.valueOf(StandardCharsets.UTF_8));
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                System.out.println(line);
            }
            socket.close();
        }catch (Exception e){
            new Exception("超时了").printStackTrace();
        }
    }
}
