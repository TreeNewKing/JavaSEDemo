package com.se.dp.myApplication.factory;

import com.se.dp.myApplication.id.ID;
import com.se.dp.myApplication.id.Uuid;

import java.util.UUID;

public class UuIdFactory implements IDFactory {


    @Override
    public String info() {
        return "返回String类型的uuid实现";
    }

    @Override
    public ID getIdGenarator() {
        return new Uuid();
    }
}
