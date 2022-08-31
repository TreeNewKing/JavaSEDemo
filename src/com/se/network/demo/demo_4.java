package com.se.network.demo;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 半关闭
 */
public class demo_4 {
    public static void main(String[] args) {

    }

    public static void demo1(){
        try {
            Socket socket = new Socket("baidu.com", 80);
            Scanner scanner = new Scanner(socket.getInputStream(), String.valueOf(StandardCharsets.UTF_8));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//            经过一系列操作
            socket.shutdownOutput();//关闭后处于半关闭状态。但是对方可以返回响应信息,todo 那如果关闭的是输入流又有什么效果呢


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * todo 非阻塞套接字的使用
     * http://www.blogjava.net/kata/articles/36218.html
     */
    public static void demo2(){
//        SocketChannel open = SocketChannel.open(new InetSocketAddress("baidu.com", 80));
//        Scanner scanner = new Scanner(open, StandardCharsets.UTF_8);

    }
}
