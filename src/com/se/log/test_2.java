package com.se.log;

import java.io.IOException;
import java.util.logging.*;

public class test_2 {

    public static void main(String[] args) throws IOException {
//        test1();
    test2();
    }
    /*
    设置日志记录器的处理器
    */
   public static void test1(){
       Logger logger = Logger.getLogger("demo");
       logger.setLevel(Level.INFO);
       ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);
        logger.setUseParentHandlers(false);//如果不设置这个的话logger的内容会被重复处理（默认祖先处理器 ""
        logger.addHandler(consoleHandler);
        boolean flage=false;
        /*
        * log 方法支持占位符。但是info方法不支持。info 方法可以使用lamda 表达式生成输出字符串
        * */
        logger.info(()->{ if (flage==true)return  "yes";
                           else    return "No";});
    }
    /*
    * 将日志也特定模式输出到对应位置
    * */
    public  static  final String path=System.getProperty("user.dir");
    public  static  void test2() throws IOException {
//    定义日志记录器
        Logger logger = Logger.getLogger("demo");
//     定义日志处理器
        FileHandler fileHandler=new FileHandler(path+"\\test.log",true);//规定的路径目录必须存在不然会发生IO异常
//        格式化输出格式
        fileHandler.setFormatter(new SimpleFormatter());
//        加入处理器到记录器
        logger.addHandler(fileHandler);
//        产生日志
        logger.info("hello");
        logger.finer("程序员可见，日常开发不可见");
        /*
        * 因为没有取消父处理器。所以info以上都会输出到控制台
        *
        * */
        test_1.main(null);
    }
}
