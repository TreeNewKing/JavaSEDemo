package com.se.exception.demo;

import com.se.exception.ep.TestException;
/*
* 异常可以捕获后不做任何处理，finally中不要放任何和流程有关的语句：return,throw，break，continu等。这破坏了语意的顺序。参数一些意外的结果
* */
public class Test_3 {
    public static void main(String[] args) {
        System.out.println(demo_1());
    }
public static int demo_1(){
    try {
        /*会被编译器检查出来*/
//        throw new TestException("抛出异常但不处理");
        return 1;
//        return Integer.parseInt("hhh");
    }finally{
        return 2;
    }
}

}
