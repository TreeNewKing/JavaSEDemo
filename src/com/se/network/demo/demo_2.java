package com.se.network.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class demo_2 {
    public static void main(String[] args) throws UnknownHostException {
//demo1();
//demo2();
    }
    public  static  void demo1() throws UnknownHostException {
        //        解析时间服务的ip
        InetAddress[] allByName = InetAddress.getAllByName("time-a.nist.gov");
        for (InetAddress inetAddress : allByName) {
            System.out.println(inetAddress);
        }
//解析百度的ip
        InetAddress[] allByName_1 = InetAddress.getAllByName("baidu.com");
        for (InetAddress inetAddress : allByName_1) {
            System.out.println(inetAddress);
        }
    }

    /**
     * https://blog.csdn.net/fengzi_big/article/details/120927254
     * @throws UnknownHostException
     * fixme 获取的是本地虚拟地址。怎么样才能获取到网关ip呢
     */
    public static  void demo2() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

    }
}
