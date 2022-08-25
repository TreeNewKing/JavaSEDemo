package com.se.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class test_1 {
    /*
    * Logger ->日志记录器
    *
    *
    * */
    public static void main(String[] args) {
//        test1();
//            test2();
    test3();
//    test4();
    }
    /*全局日志记录器*/
    public  static void test1(){
        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("demoLog");
    }
       private static Logger myLogger=Logger.getLogger("com.se.log");
    /*高级日志
    * 日志分级别输出
    * 只能输出info以上级别的日志。若想要修改这一限制需要修改jdk的配置文件:
    *  Jdk9之前在 jre/lib/logging.properties
    * */
    public  static void test2(){
//        Logger.getGlobal().setLevel(Level.SEVERE);
        myLogger.setLevel(Level.SEVERE);
        myLogger.severe("sever");
        myLogger.warning("warning");
        myLogger.info("info");
        myLogger.config("config");
        myLogger.fine("fine");
        myLogger.finer("finer");
        myLogger.finest("finest");
    }
    /*
    * 带异常的输出和不带异常得到输出
    * */
    public  static void test3(){
/* fixme fail*/
        myLogger.throwing("com.se.log.test_1","test3",new Exception("测试异常"));

        /*
        * 直接输出是没有调用栈信息输出的
        * log方法的第三位可以有两种选择:输入一种异常。或则产生数组对前面占位符补充
        * */
        myLogger.log(Level.WARNING,"err",new Exception("ex"));
        myLogger.log(Level.WARNING,"param1:{0}\nparam2:{1}",new Object[]{"v1","v2"});
    }
    /*
    *  enterning   和  exiting 的用法
    *     * */
    public static  void  test4(){
        myLogger.entering("com.se.log.test_1","test4",new Object[]{"F","END"});
        myLogger.exiting("com.se.log.test_1","test4",new Object[]{"F","END"});
        myLogger.info("嘿嘿");
    }
}
