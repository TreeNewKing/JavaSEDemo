package com.se.Interface;

import com.se.Interface.OutClass;

//TODO 静态类可以被其他类使用,而非静态类不行
public class OutClass_ {
    public static void main(String[] args) {
        OutClass.InnerClass innerClass=new OutClass.InnerClass("TEST");
        System.out.println(innerClass);
//        OutClass.InnerClass1 innerClass1=new OutClass.InnerClass1();
    }

}
