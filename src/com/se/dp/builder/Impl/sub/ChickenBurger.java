package com.se.dp.builder.Impl.sub;

import com.se.dp.builder.Impl.sub.Burger;

public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}