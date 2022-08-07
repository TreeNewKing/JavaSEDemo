package com.se.stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class test_1 {
    public static void main(String[] args) throws IOException {
//        路径是从项目地址开始的。使用Paths.get 方法转化为path对象可进一步完成其他操作
    String contents=new String(Files.readAllBytes(Paths.get("src","com","se","stream","tmp.txt")), StandardCharsets.UTF_8);
        System.out.println(contents);
//        fixme 非字母分割符的含义是什么。为什么中文没有被当作非字母分隔符
    List<String> list = Arrays.asList(contents.split("\\PL+"));
        System.out.println("输出字符串");
        list.forEach(System.out::println);
        int count=0;
        for (String s : list) {
           if (s.length()>10)count++;
        }
        System.out.println("长单词个数为"+count);
        System.out.println("流的模式计算count");
        long count1 = list.stream().filter(w -> w.length() > 10).count();
        System.out.println("长单词个数为"+count1);
        Stream<String> a = Stream.of("a", "c");
        a.forEach((String s)->{
            System.out.println(s);
        });
    }

}
