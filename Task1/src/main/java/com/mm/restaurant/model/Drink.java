package com.mm.restaurant.model;

import lombok.Setter;


public class Drink extends Meal{

    @Setter DrinkOptions drinkOptions;

    @Override
    public String toString() {
        String newLine = "\n";
        return "Drink summary:" + newLine +
                "1." + this.getName() + newLine +
                "2." + this.getPrice() + newLine +
                "3." + drinkOptions;
    }
}
