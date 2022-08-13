package com.se.dp.builder.Impl.sub;

import com.se.dp.builder.Impl.Wrapper;
import com.se.dp.builder.Item;
import com.se.dp.builder.Packing;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}