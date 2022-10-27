package org.example.Service;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import org.example.entity.AbstractMeal;
import org.example.entity.Dish;
import org.example.entity.Drink;
import org.example.entity.enums.CuisineType;
import org.example.entity.enums.DishType;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.controller.Configurations.properties;
import static org.example.controller.Controller.cuisineType;


public class MenuService {
    List<Drink> drinks = new ArrayList<>();
    List<Dish> dishes = new ArrayList<>();

    public void addItem(AbstractMeal item) {
        switch (item.getClass().getSimpleName()) {
            case "Dish" -> dishes.add((Dish) item);
            case "Drink" -> drinks.add((Drink) item);
        }
    }

    public void printDishes(DishType dishType) {
        switch (dishType) {
            case COURSE -> System.out.println("\nCourse meals");
            case DESSERT -> System.out.println("\nDesserts");
        }
        List<Dish> items = getAllDishesBy(cuisineType, dishType);
        System.out.println(AsciiTable.getTable(AsciiTable.FANCY_ASCII, items,
                Arrays.asList(
                        new Column().minWidth(5).with(dish -> String.valueOf(items.indexOf(dish))),
                        new Column().header("Name").with(AbstractMeal::getName),
                        new Column().header("Price").with(dish -> dish.getPrice() + " $"),
                        new Column().header("Type").with(dish -> String.valueOf(dish.getDishType()))
                )));
    }

    public void printDrinks() {
        System.out.println("\nDrinks");
        List<Drink> items = getAllDrinksBy(cuisineType);
        System.out.println(AsciiTable.getTable(AsciiTable.FANCY_ASCII, items,
                Arrays.asList(
                        new Column().minWidth(5).with(drink -> String.valueOf(items.indexOf(drink))),
                        new Column().header("Name").with(AbstractMeal::getName),
                        new Column().header("Price").with(drink -> drink.getPrice() + " $")
                )));
    }

    public List<Dish> getAllDishesBy(CuisineType cuisineType, DishType dishType) {

        return dishes.stream()
                .filter(dish ->
                        dish.getCuisine().equals(cuisineType) &&
                                dish.getDishType().equals(dishType))
                .toList();
    }

    public List<Drink> getAllDrinksBy(CuisineType cuisineType) {
        return drinks.stream()
                .filter(drink -> drink.getCuisine().equals(cuisineType))
                .toList();
    }

    public CuisineType getCuisine(BufferedReader br) throws Exception {
        System.out.println("Which cuisine do you prefer today?");
        System.out.println(properties.getProperty("app.cuisines"));
        String choice = br.readLine();

        CuisineType result;
        switch (choice) {

            case "1" -> result = CuisineType.POLISH;
            case "2" -> result = CuisineType.MEXICAN;
            case "3" -> result = CuisineType.ITALIAN;
            default -> throw new Exception("Sorry, this cuisine is not available yet");
        }

        System.out.println("Good choice!");
        return result;
    }

}
