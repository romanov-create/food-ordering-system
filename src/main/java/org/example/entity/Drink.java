package org.example.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.entity.enums.CuisineType;

@Getter
@Setter
public class Drink extends AbstractMeal {

    private boolean iceCubes;
    private boolean lemon;

    @Builder
    public Drink(String name, double price, CuisineType cuisine) {
        super(name, price, cuisine);
    }

    @Override
    public double getPrice() {

        double price = super.getPrice();

        if (iceCubes && lemon) {
            return price + 1;
        }
        if (iceCubes) {
            return price + 0.5;
        }
        if (lemon) {
            return price + 0.7;
        }

        return price;
    }

    public void setIceCubesAndLemon(boolean iceCubes, boolean lemon) {
        this.iceCubes = iceCubes;
        this.lemon = lemon;
    }
}
