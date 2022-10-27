package org.example.controller;

import jline.console.ConsoleReader;
import org.example.Service.MenuService;
import org.example.Service.OrderService;
import org.example.entity.enums.CuisineType;
import org.example.entity.enums.DishType;
import org.example.preps.InitMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Controller {

    private final Properties properties = Configurations.properties;
    public static CuisineType cuisineType;
    public static MenuService menuService;


    public void setCuisine() throws Exception {
        menuService = new InitMenu().init();

        BufferedReader brCuisine = new BufferedReader(new InputStreamReader(System.in));
        cuisineType = menuService.getCuisine(brCuisine);

        control(menuService, cuisineType);
    }

    private void control(MenuService menuService, CuisineType cuisineType) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(properties.getProperty("app.controls.main"));
        String pos;
        while ((pos = br.readLine()) != null) {
            switch (pos) {
                case "1" -> showMenu(menuService, cuisineType);
                case "2" -> makeOrder();
                case "3" -> setCuisine();
            }
        }
    }

    public void showMenu(MenuService menuService, CuisineType cuisineType) throws Exception {
        menuService.printDishes(DishType.COURSE);
        menuService.printDishes(DishType.DESSERT);
        menuService.printDrinks();

        control(menuService, cuisineType);

    }

    private void makeOrder() throws Exception {

        OrderService orderService = new OrderService();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        orderService.orderDish(DishType.COURSE);
        orderService.orderDish(DishType.DESSERT);
        orderService.orderDrink(br);
        orderService.proceed();
        clearConsole();
        control(menuService, cuisineType);

    }

    private void clearConsole() throws InterruptedException {
        System.out.println("**********WAITING FOR NEW ORDER**********");
        Thread.sleep(5000);
        try (ConsoleReader cr = new ConsoleReader()) {
            cr.clearScreen();
        } catch (IOException e) {
            System.out.println("Internal causes, try later");
        }

    }


}

