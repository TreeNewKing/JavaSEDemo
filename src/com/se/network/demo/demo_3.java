package com.se.network.demo;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Logger;

    /**
     * 使用TCP完成聊天功能
     * todo 后期做优化。
     *descrip:
     *          demo1可以简单实现收发信息。但是是单线程的。demo3是多线程的服务端可以接收多个请求。demo2是一个简单的阻塞测试
     *          现在是首发是一个链式的收发。服务端收到客户端信息后才能发送信息给客户端。然后客户端发送给服务端。依次循环
     *          demo3使用多线程每次监听到新的请求后就创建一个子线程
     *              但是每个子线程类若需要监听客户端的信息就需要一个扫描器阻塞等待。这会让程序没法执行其他操作。所以是不是需要一个创建一个子线程来做接收信息的操作？
     *
     *
     * @throws IOException
     */
public class demo_3 {
    public static final Logger log=Logger.getLogger("com.se.network.demo.demo_3");
    public static void main(String[] args) throws IOException {
//        demo1();
//        demo2();
        demo3();
    }

    public  static void demo1() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8191);
       Socket accept = serverSocket.accept();//会阻塞在这里
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);

        int count=0;
        boolean run=true;
//       连接欢迎信息
        while (accept.isConnected()&&run==true){
        writer.write("欢迎x_"+count+++"\r\n");
        if (count==3){writer.println("请输入Bye离开");writer.flush();run=false;};
        }

        Scanner scanner=new Scanner(inputStream, String.valueOf(StandardCharsets.UTF_8));
//       客户端信息处理器
        while (scanner.hasNextLine()){
            String clientInfo = scanner.nextLine();
            if (clientInfo.equals("Bye")) {
                writer.println("滚!");
                writer.close();
                System.out.println("客户离开");
                serverSocket.close();
            }else {
                System.out.println("收到客户端信息"+clientInfo);
                System.out.println("请回复");
                while(true){
                    Scanner input=new Scanner(System.in);
                    writer.println(input.nextLine());
                    break;
                }
            }
        }

    }

    /**
     *  scanner.hasNextLine()当源是标准输入的时候会阻塞接收。而如果源是文件则不会阻塞.while 不会监听条件变化。
     */
    public static void demo2(){
        boolean flage=false;
        int count=0;
        while (flage){
            if (count==4)break;
            count++;
            System.out.println("进入循环1");
        }
        while (flage){
            if (count==4)break;
            count++;
            System.out.println("进入循环2");
        }
        flage=true;
        System.out.println("结束");
    }

    /**
     *
     *
     */
    public static void demo3() throws IOException {

        ServerSocket serverSocket = new ServerSocket(8191);//多个线程共享一个端口
log.info("开始监听8191端口");
        while (true){
            log.info("开始阻塞获取请求");
            Socket  accept=serverSocket.accept();          //进入阻塞
            log.info("获得请求成功");
            Thread thread=new Thread(()->{
                try {
                    log.info("进入请求处理线程");
                    InputStream inputStream = accept.getInputStream();
                    OutputStream outputStream = accept.getOutputStream();
                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
                    int count=0;
                    boolean run=true;
                    //       连接欢迎信息
                    while (accept.isConnected()&&run==true){
                        log.info("开始写入欢迎信息"+count);
                        writer.write("欢迎x_"+count+++"\r\n");
                        if (count==3){log.info("欢迎信息结束");writer.println("请输入Bye离开");writer.flush();run=false;};
                    }

                    Scanner scanner=new Scanner(inputStream, String.valueOf(StandardCharsets.UTF_8));
//       客户端信息处理器
                    log.info("开始阻塞接收用户信息");
                    while (scanner.hasNextLine()){          //子线程内部阻塞
                        log.info("成功获取用户输入");
                        String clientInfo = scanner.nextLine();
                        if (clientInfo.equals("Bye")) {
                            log.info("开始回复用户退出请求");
                            writer.println("滚!");
                            writer.close();
                            System.out.println("客户离开");
                            serverSocket.close();
                        }else {
                            System.out.println("收到客户端信息"+clientInfo);
                            System.out.println("请回复");
//                            从客户端接收
                            while(true){
                                log.info("开始回复客户端");
                                Scanner input=new Scanner(System.in);//阻塞等待键盘输入;
                                writer.println(input.nextLine());
                                log.info("回复成功,等待客户端信息");
                                break;
                            }
                        }
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            });
            log.info("进入子线程");
            thread.start();
        }


    }

}
