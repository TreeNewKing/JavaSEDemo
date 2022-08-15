package com.se.exception.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test_4 {
    public static void main(String[] args) {

    }
    public  static  void  demo_1() throws FileNotFoundException {
        try (FileOutputStream fos=new FileOutputStream("/text.txt"); FileInputStream fileInputStream=new FileInputStream("/text.txt")){
            System.out.println("这样打开流之后出现异常");
//            无需添加关闭流的操作，同时也无需finally语句关闭资源
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
