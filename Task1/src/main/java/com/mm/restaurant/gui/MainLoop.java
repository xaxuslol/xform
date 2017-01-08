package com.mm.restaurant.gui;

import com.mm.restaurant.data.MealsLoader;
import com.mm.restaurant.data.Menu;
import com.mm.restaurant.input.InputManager;

public class MainLoop {
    public static void main(String[] args) {

        InputManager inputManager = new InputManager();
        DataRepresenter converter = new DataRepresenter();
        MealsLoader mealsLoader = new MealsLoader();
        Menu menu = Menu.builder().dessertList(mealsLoader.loadDesserts())
                .dishList(mealsLoader.loadDishes())
                .drinkList(mealsLoader.loadDrinks())
                .build();
        Waiter waiter = new Waiter(menu, inputManager, converter);


        waiter.greet();
        waiter.askAboutMeal();
        waiter.askAboutDessert();
        waiter.askAboutDrink();
        waiter.askAboutExtrasToDrink();
        waiter.calculateBill();
    }
}
