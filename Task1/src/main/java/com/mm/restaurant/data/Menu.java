package com.mm.restaurant.data;

import com.mm.restaurant.model.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class Menu {
    public List<Drink> drinkList;
    public List<Dish> dishList;
    public List<Dessert> dessertList;


}
