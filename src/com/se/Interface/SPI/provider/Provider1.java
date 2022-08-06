package com.se.Interface.SPI.provider;

import com.se.Interface.SPI.API;

public class Provider1 implements API {
    @Override
    public String getInfo() {
        return "服务一";
    }
}
