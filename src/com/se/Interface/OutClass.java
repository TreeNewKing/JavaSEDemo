package com.se.Interface;

public class OutClass {
    private final String role="root";
    public static  class InnerClass{
    private  String str;
        public InnerClass(String str){
//            System.out.println(role);//无法访问
            this.str=str;
        }
        @Override
        public String toString() {
            return "InnerClass{" +
                    "str='" + str + '\'' +
                    '}';
        }
    }

    public class InnerClass1{
        private String str;

        public InnerClass1(String str) {
            System.out.println("内部类获取到外部类属性:"+role);
            this.str = str;
        }

        @Override
        public String toString() {
            return "InnerClass1{" +
                    "str='" + str + '\'' +
                    '}';
        }
    }
    public  void  test_innerclass(){
        InnerClass1 innerClass1=new InnerClass1("嘿嘿嘿");
        System.out.println(innerClass1);
    }

       static InnerClass1 innerClass;
/*
* TODO 一般情况下都使用静态内部类，因为静态内部类可以被实例化，可以脱离本类使用
*                           但是静态内部类无法访问到外部类，无法脱离本类被使用 （这的实例化是指在static的主方法内）
* */
    public static void main(String[] args) {
//        静态类可初始化并使用
        InnerClass node=new InnerClass("hello");
        System.out.println(node);
//        非静态类是没法实例化的
        OutClass outClass=new OutClass();
        outClass.test_innerclass();

    }
}
