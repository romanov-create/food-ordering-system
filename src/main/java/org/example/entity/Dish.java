package org.example.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.entity.enums.CuisineType;
import org.example.entity.enums.DishType;

@Getter
@Setter
public class Dish extends AbstractMeal{
    private DishType dishType;

    @Builder
    public Dish(String name, double price, CuisineType cuisine, DishType dishType) {
        super(name, price, cuisine);
        this.dishType = dishType;
        this.setPrice(price);
    }

}
