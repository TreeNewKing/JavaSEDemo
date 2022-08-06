package com.se.Interface;

import javax.swing.Timer;
import java.util.*;

public class LambdaDemo {
    public static void main(String[] args) {
List list=new LinkedList<String>();
        System.out.println(list);
    }
    public  void test_1(){
        String str1="aac";
        String str2="baaaa";
        List list= Arrays.asList(str1,str2);
        List list1=list;
        System.out.println("默认排序");
        Collections.sort(list);//默认排序字典序小的在前面
        System.out.println(list);
        System.out.println("自定义排序");
        //如果某个函数式接口的抽象方法只有一个参数的话。参数的位置直接写上实参就可以了
        Collections.sort(list1,(String s1,String s2)->s2.length()-s1.length());
        System.out.println(list1);
        /*
        * 默认排序
        [aac, baaaa]
        自定义排序
        [baaaa, aac]
        * */
    }
//    TODO sour需要的是一个 <?super T>的类型。但是返回的函数式接口返回的是int 这个泛型复合吗？
    public  void  test_2(){
        Timer timer = new Timer(1000, System.out::println);
        List<String> strs =Arrays.asList("hello","word");
        Collections.sort(strs,String::compareToIgnoreCase);
    }
    /*
  * FIXME
  *  Exception in thread "main" java.lang.UnsupportedOperationException
at java.util.AbstractList.remove(AbstractList.java:161)
at java.util.AbstractList$Itr.remove(AbstractList.java:374)
at java.util.Collection.removeIf(Collection.java:415)
at LambdaDemo.main(LambdaDemo.java:11)
*       List<String> list= Arrays.asList(str1,str2);
*       使用aslist生成了之后不能增减和修改数据否则会抛出不可操作异常
  * */
    public void  test_3(){
        String str1="aac";
        String str2="baaaa";
        List<String> list=new ArrayList();
        list.add("aac");
        list.add("bbc");
        list.removeIf((String s)->{if (s.equals("aac")){
            return true;
        }
            return false;
        });
        System.out.println(list);

    }
}
