package com.se.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class test_2 {
    public static void main(String[] args) {
//        randomStram();
//        finalStream();
//        patterStream();
    parallelStream();
    }

    public  static void  finalStream(){
        Stream<String> generate = Stream.generate(() -> "echo");
        generate.forEach(System.out::println);
    }
    public static void randomStram(){

//        //随机流单参数
//        Stream<Double> generate = Stream.generate(Math::random);
//        generate.forEach(System.out::println);
//        自定定义随机流
//        Stream<Double> generate = Stream.generate(() -> {
//            return new Random().nextDouble();
//        });
//        generate.forEach(System.out::println);
//        使用流进行循环，java 11对改方法参数进行了重构
        Stream.iterate(3,n->{return  n+1;}).limit(3).forEach(System.out::println);
    }
public static void patterStream(){
    Pattern.compile("\\PL+").splitAsStream("hello word").forEach(System.out::println);
    }
    /*并行流访问顺序随机*/
    public  static  void parallelStream(){
        List list= Arrays.asList(1,2,3,4,5,6,7,8);
        list.parallelStream().forEach(System.out::println);
    }
}
