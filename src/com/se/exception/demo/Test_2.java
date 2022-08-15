package com.se.exception.demo;

import com.se.exception.ep.TestException;
/*
* 1)===的输出在运行时不能达到预期效果，但是debug运行事件可以达到切割的效果
* 2）当异常交给虚拟机处理时，输出的异常栈不会包括被转化的异常而是会在异常输出完了之后在最后补充一个caused by 进行输出
* */
public class Test_2 {
    public static void main(String[] args) throws Exception {
        System.out.println("========================================");
        try {
            demo1();
        } catch (Exception e) {
            e.getCause().printStackTrace();
        System.out.println("========================================");
        }
        demo1();
        System.out.println("========================================");

    }
    public static void demo1() throws Exception {
        try {
            throw new TestException("产生一个自定义异常");
        } catch (TestException oldEP) {
            Exception newEP = new Exception();
            newEP.initCause(oldEP);
            throw  newEP;
        }
    }
}
