package com.se.dp.builder.Impl.builder;

import com.se.dp.builder.Impl.Meal;
import com.se.dp.builder.Impl.sub.ChickenBurger;
import com.se.dp.builder.Impl.sub.Coke;
import com.se.dp.builder.Impl.sub.Pepsi;
import com.se.dp.builder.Impl.sub.VegBurger;

public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
