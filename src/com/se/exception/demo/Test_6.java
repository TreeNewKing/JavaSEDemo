package com.se.exception.demo;

/*
* todo 断言应该和api的注释文档配合使用。但是他的一般应用场景是什么呢？
* */
public class Test_6 {
    public static void main(String[] args) {
        int x=0;
        assert x!=0:"断言作用";//断言输出需要在vm 参数加上 -ea
        System.out.println("继续输出失败");
    }
}
