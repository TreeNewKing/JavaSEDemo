package com.se.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class test_3 {
    public static void main(String[] args) {
mapStream();
    }
    /*
    *fixme 不理解的offsetByCodePoints用法
    * */
    public  static void mapStream(){
        Arrays.asList("hello","Word").stream().map(String::toLowerCase).forEach(System.out::println);
        Arrays.asList("hello","Word").stream().map(w->w.offsetByCodePoints(0,3)).forEach(System.out::println);
        String greeting = "Hello\uD835\uDD6b";
        System.out.println(greeting+"长度为"+greeting.length());
        System.out.println(greeting+",H到E偏移一个代码点后。对应的下标位置"+greeting.offsetByCodePoints(0,1));
        System.out.println(greeting+",H到E偏移俩个代码点后。对应的下标位置"+greeting.offsetByCodePoints(0,2));
        System.out.println(greeting+",o到特殊字符偏移一个代码点后。对应的下标位置"+greeting.offsetByCodePoints(4,1));
        System.out.println(greeting+",o到特殊字符偏移两个代码点后。对应的下标位置"+greeting.offsetByCodePoints(4,2));
        System.out.println(greeting.codePointAt(4));
        System.out.println(greeting.codePointAt(5));
        System.out.println(greeting.codePointAt(6));
        ;
    }
}
