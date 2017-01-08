package com.mm.restaurant.model;

import lombok.Getter;
import lombok.Setter;


public abstract class Meal {

    @Getter @Setter int price;
    @Getter @Setter String name;

}
