package org.example.Service;



import org.example.controller.Configurations;
import org.example.entity.Dish;
import org.example.entity.Drink;
import org.example.entity.Order;
import org.example.entity.enums.DishType;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static org.example.controller.Configurations.properties;
import static org.example.controller.Controller.cuisineType;
import static org.example.controller.Controller.menuService;


public class OrderService {

    public Order order = new Order();

    public void proceed() {
        countTotal(order);

    }
    public void proceed(Order order) {
        countTotal(order);

    }

    private void countTotal(Order order) {
        double total;
        double drinksTotal = 0;
        double dishesTotal = 0;
        try {
            dishesTotal = order.getDishes().stream()
                    .map(Dish::getPrice)
                    .reduce(Double::sum).get();
        } catch (NoSuchElementException ignored) {
        }

        try {
            drinksTotal = order.getDrinks().stream()
                    .map(Drink::getPrice)
                    .reduce(Double::sum).get();

        } catch (NoSuchElementException ignored) {
        }

        total = dishesTotal + drinksTotal;
        order.setTotal(total);
        order.getDrinks().forEach(drink -> drink.setIceCubesAndLemon(false, false));

        System.out.println("Your bill is " +
                total + "$." +
                "\nGlad to see you next time!");
    }

    public void orderDish(DishType dishType) {
        try {
            List<Dish> courseDishes = menuService.getAllDishesBy(cuisineType, dishType);
            menuService.printDishes(dishType);
            System.out.println(properties.getProperty("app.controls.order"));

            List<Integer> courseOrderList = Configurations.readInputValuesAndReturnArray();
            courseOrderList.forEach(dessert -> order.getDishes().add(courseDishes.get(dessert)));

        } catch (Exception e) {
            System.out.println("You skipped" + dishType + "dishes");
        }
    }

    public void orderDrink(BufferedReader br) {
        try {
            List<Drink> drinks = menuService.getAllDrinksBy(cuisineType);
            menuService.printDrinks();
            System.out.println(properties.getProperty("app.controls.order"));


            List<Integer> drinksOrderList = Configurations.readInputValuesAndReturnArray();
            drinksOrderList.forEach(drink -> order.getDrinks().add(drinks.get(drink)));

            List<Drink> orderedDrinks = order.getDrinks();
            orderedDrinks.forEach(drink -> {
                System.out.println("You ordered " + drink.getName());
                System.out.println(properties.getProperty("app.controls.addons"));
                while (true) {
                    try {
                        switch (br.readLine()) {
                            case "1" -> drink.setIceCubes(true);
                            case "2" -> drink.setLemon(true);
                            case "3" -> {
                                drink.setLemon(true);
                                drink.setIceCubes(true);
                            }
                        }
                        break;
                    } catch (IOException e) {
                        System.out.println("Unknown symbol, try again");
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("You skipped drinks");
        }
    }


}
