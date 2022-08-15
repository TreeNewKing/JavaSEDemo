package com.se.exception.demo;

public class Test_5 {
    public static void main(String[] args) {
        demo_1();
    }
    public static void demo_1(){
        Throwable s=new Throwable("hhh");
        System.out.println(s.getStackTrace());//JDK9更新了一个效率更高的StackWallker类。
    }
}
