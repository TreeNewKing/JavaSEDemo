package com.se.dp.myApplication;

import com.se.dp.myApplication.factory.IDFactory;
import com.se.dp.myApplication.factory.LongIdFactory;
import com.se.dp.myApplication.factory.UuIdFactory;
import com.se.dp.myApplication.id.ID;
import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.EventListener;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        System.out.println("输入1获取uuid,输入2获取Long值id");
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        IDFactory idFactory=config(n);
        System.out.println(idFactory.info());
        System.out.println(idFactory.getIdGenarator().getID());
    }

    /**
     *将系统的构建和使用分开,所以将配置实例化过程单独提取出来
     * @param userInput
     * @return
     */
    public static IDFactory config(int userInput){
        if (userInput==1)return new UuIdFactory();
        else if (userInput==2)return new LongIdFactory();
        throw new RuntimeException("用户输入异常");
    }
}
