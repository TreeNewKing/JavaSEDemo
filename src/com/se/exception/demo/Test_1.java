package com.se.exception.demo;

import com.se.exception.ep.TestException;

public class Test_1 {
    public static void main(String[] args) {
        System.out.println("开始测试");
        try {
            demo1();
        } catch (TestException |IndexOutOfBoundsException e) {//fixme 捕获多个异常时。异常变量隐含为final变量，所以e不能赋多个变量？？
            e.printStackTrace();
        }
    }
   public static String demo1() throws TestException {
       System.out.println("进入方法");
       throw  new TestException("抛出异常");
//       System.out.println("方法介绍");//抛出异常后控制权交给处理器
   }
}
