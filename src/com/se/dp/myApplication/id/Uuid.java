package com.se.dp.myApplication.id;

import java.util.UUID;

public class Uuid implements ID{
    @Override
    public String getID() {
        return UUID.randomUUID().toString();
    }
}
