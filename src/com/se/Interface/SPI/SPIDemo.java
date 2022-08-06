package com.se.Interface.SPI;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPIDemo {
       public static ServiceLoader<API> load = ServiceLoader.load(API.class);
    public static void main(String[] args) {
        Iterator<API> iterator = load.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getInfo());
        }
    }

}
