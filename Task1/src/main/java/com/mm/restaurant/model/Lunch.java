package com.mm.restaurant.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Lunch {
    @Setter Dish dish;
    @Setter Dessert dessert;
    @Setter @Getter Drink drink;
    @Override
    public String toString() {
        int totalPrice = dish.getPrice() + dessert.getPrice() + drink.getPrice();
        String newLine = "\n";
        return "Lunch summary:" + newLine +
                "1." + dish.getName() + " " + dish.getPrice() + newLine+
                "2." + dessert.getName() + " " + dessert.getPrice()+ newLine +
                "3." + drink.getName() + " " + drink.getPrice() + newLine +
                "Total bill : " + totalPrice;
    }
}
