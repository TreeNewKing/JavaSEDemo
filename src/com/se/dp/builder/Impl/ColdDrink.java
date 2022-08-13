package com.se.dp.builder.Impl;

import com.se.dp.builder.Item;
import com.se.dp.builder.Packing;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}