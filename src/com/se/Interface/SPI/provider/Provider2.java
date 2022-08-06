package com.se.Interface.SPI.provider;

import com.se.Interface.SPI.API;

public class Provider2 implements API {

    @Override
    public String getInfo() {
        return "服务二";
    }
}
