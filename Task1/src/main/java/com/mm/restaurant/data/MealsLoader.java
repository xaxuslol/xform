package com.mm.restaurant.data;

import com.mm.restaurant.model.Cuisine;
import com.mm.restaurant.model.Dessert;
import com.mm.restaurant.model.Dish;
import com.mm.restaurant.model.Drink;

import java.util.ArrayList;
import java.util.List;

public class MealsLoader {


    //stub methods, normally you would just get object from DB, more info in README

    public List<Dessert> loadDesserts() {
        List <Dessert> result = new ArrayList<>();

        Dessert dessert = new Dessert();
        dessert.setName("Dessert Number One ");
        dessert.setPrice(13);
        result.add(dessert);

        dessert = new Dessert();
        dessert.setName("Dessert Number two");
        dessert.setPrice(14);
        result.add(dessert);

        dessert = new Dessert();
        dessert.setName("Dessert Number Three");
        dessert.setPrice(15);
        result.add(dessert);

        return result;
    }

    public List<Dish> loadDishes() {
        List <Dish> result = new ArrayList<>();

        Dish dish = new Dish();
        dish.setName("Dish Number One");
        dish.setPrice(13);
        dish.setCuisine(Cuisine.ITALIAN);
        result.add(dish);

        dish = new Dish();
        dish.setName("Dish Number Two");
        dish.setPrice(14);
        dish.setCuisine(Cuisine.MEXICAN);
        result.add(dish);

        dish = new Dish();
        dish.setName("Dish Number Three");
        dish.setPrice(15);
        dish.setCuisine(Cuisine.POLISH);
        result.add(dish);

         dish = new Dish();
        dish.setName("Dish Number Four");
        dish.setPrice(13);
        dish.setCuisine(Cuisine.ITALIAN);
        result.add(dish);

        dish = new Dish();
        dish.setName("Dish Number Five");
        dish.setPrice(14);
        dish.setCuisine(Cuisine.MEXICAN);
        result.add(dish);

        dish = new Dish();
        dish.setName("Dish Number Six");
        dish.setPrice(15);
        dish.setCuisine(Cuisine.POLISH);
        result.add(dish);

        return result;
    }

    public List<Drink> loadDrinks() {
        List <Drink> result = new ArrayList<>();

        Drink drink = new Drink();
        drink.setName("Drink One");
        drink.setPrice(13);
        result.add(drink);

        drink = new Drink();
        drink.setName("Drink Two");
        drink.setPrice(14);
        result.add(drink);

        drink = new Drink();
        drink.setName("Drink Three");
        drink.setPrice(15);
        result.add(drink);

        return result;
    }
}
