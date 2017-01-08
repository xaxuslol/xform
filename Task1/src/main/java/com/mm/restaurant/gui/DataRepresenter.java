package com.mm.restaurant.gui;

import com.mm.restaurant.model.Cuisine;
import com.mm.restaurant.model.Dish;
import com.mm.restaurant.model.Meal;

import java.util.List;

public class DataRepresenter {
    private String space = " ";
    private String newLine = "\n";

    public  String convertToMenuFormat(List<? extends Meal> listToBePresented) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < listToBePresented.size(); i++) {
            Meal currentMeal = listToBePresented.get(i);
            result.append(i).append(space).append(currentMeal.getName()).append(space).append(currentMeal.getPrice()).append(newLine);
        }
        return result.toString();
    }

    public  String convertToMenuFormat(List<Dish> listToBePresented, Cuisine cuisine) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < listToBePresented.size(); i++) {
            Dish currentDish = listToBePresented.get(i);
            if (currentDish.getCuisine().equals(cuisine))
                result.append(i).append(space).append(listToBePresented.get(i).getName()).append(space).append(listToBePresented.get(i).getPrice()).append(newLine);
        }
        return result.toString();
    }

    public  String convertToMenuFormat(Object[] values) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            result.append(i).append(space).append(values[i]).append(newLine);
        }
        return result.toString();
    }
}
