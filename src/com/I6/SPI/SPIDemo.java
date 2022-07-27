package com.I6.SPI;

import java.util.ServiceLoader;

public class SPIDemo {
       public static ServiceLoader<API> load = ServiceLoader.load(API.class);
    public static void main(String[] args) {
        while (load.iterator().hasNext()) {
            load.iterator().next().getInfo();
        }
    }

}
