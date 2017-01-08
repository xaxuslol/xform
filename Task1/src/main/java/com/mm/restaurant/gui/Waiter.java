package com.mm.restaurant.gui;

import com.mm.restaurant.data.Menu;
import com.mm.restaurant.model.*;
import com.mm.restaurant.input.InputManager;

import java.util.List;
import java.util.stream.Collectors;

public class Waiter {

    private final String GREET_TEXT = "Welcome in our restaurant\nOPTION | NAME | PRICE";
    private final String DRINK_EXTRA_TEXT = "Do you want something with your drink?";
    private final String CUISINE_OFFER = "What cuisine do you choose?";
    private final String MEAL_OFFER = "What meal do you choose?";
    private final String DESSERT_OFFER = "What dessert do you choose?";

    private Menu menu;
    private InputManager inputManager;
    private DataRepresenter representer;

    private Lunch lunch;
    private int maxAllowedInput;
    private int chosenOption;

    public Waiter(Menu menu, InputManager inputManager, DataRepresenter representer) {
        this.menu = menu;
        this.inputManager = inputManager;
        this.representer = representer;
    }

    public void greet() {
        System.out.println(GREET_TEXT);
        lunch = new Lunch();
    }


    public void askAboutMeal() {
        Cuisine chosenCuisine = askAboutCuisine();
        List<Dish> dishList = extractDishesWithChosenCuisine(menu.getDishList(), chosenCuisine);
        maxAllowedInput = extractMaxAllowedInput(dishList);
        System.out.println(MEAL_OFFER);
        System.out.println(representer.convertToMenuFormat(dishList, chosenCuisine));
        chosenOption = inputManager.readInput(maxAllowedInput);
        lunch.setDish(dishList.get(chosenOption));
    }

    private Cuisine askAboutCuisine() {
        System.out.println(CUISINE_OFFER);
        System.out.println(representer.convertToMenuFormat(Cuisine.values()));
        maxAllowedInput = extractMaxAllowedInput(Cuisine.values());
        chosenOption = inputManager.readInput(maxAllowedInput);
        return Cuisine.values()[chosenOption];
    }

    private List<Dish> extractDishesWithChosenCuisine(List<Dish> dishList, Cuisine cuisine) {
        return dishList.stream().filter(e -> e.getCuisine().equals(cuisine)).collect(Collectors.toList());
    }


    public void askAboutDrink() {
        List<Drink> drinkList = menu.getDrinkList();
        maxAllowedInput = extractMaxAllowedInput(drinkList);
        System.out.println(representer.convertToMenuFormat(drinkList));
        chosenOption = inputManager.readInput(maxAllowedInput);
        lunch.setDrink(drinkList.get(chosenOption));

    }

    public void askAboutDessert() {
        List<Dessert> dessertList = menu.getDessertList();
        maxAllowedInput = extractMaxAllowedInput(dessertList);
        System.out.println(DESSERT_OFFER);
        System.out.println(representer.convertToMenuFormat(dessertList));
        chosenOption = inputManager.readInput(maxAllowedInput);
        lunch.setDessert(dessertList.get(chosenOption));
    }

    public void askAboutExtrasToDrink() {
        System.out.println(DRINK_EXTRA_TEXT);
        prepareDrink();
    }

    private void prepareDrink() {
        System.out.println(representer.convertToMenuFormat(DrinkOptions.values()));
        maxAllowedInput = extractMaxAllowedInput(DrinkOptions.values());
        chosenOption = inputManager.readInput(maxAllowedInput);
        DrinkOptions chosenDrinkOption = DrinkOptions.values()[chosenOption];
        lunch.getDrink().setDrinkOptions(chosenDrinkOption);
    }

    public void calculateBill() {
        System.out.println(lunch.toString());
    }

    private int extractMaxAllowedInput(List list) {
        return list.size() - 1;
    }

    private int extractMaxAllowedInput(Object[] values) {
        return values.length - 1;
    }


}
