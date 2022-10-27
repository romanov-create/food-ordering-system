package org.example.preps;

import lombok.NoArgsConstructor;
import org.example.Service.MenuService;
import org.example.entity.Dish;
import org.example.entity.Drink;
import org.example.entity.enums.CuisineType;
import org.example.entity.enums.DishType;


@NoArgsConstructor
public class InitMenu {

    private final MenuService menuService = new MenuService();

    public MenuService init() {
        initPolish();
        initMexican();
        initItalian();

        return menuService;
    }

    private void initPolish() {
        menuService.addItem(Dish.builder()
                .name("Golabki")
                .price(6)
                .cuisine(CuisineType.POLISH)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Pierogi")
                .price(6)
                .cuisine(CuisineType.POLISH)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Draniki")
                .price(6)
                .cuisine(CuisineType.POLISH)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Kotlet schabowi")
                .price(6)
                .cuisine(CuisineType.POLISH)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Sernik")
                .price(6)
                .cuisine(CuisineType.POLISH)
                .dishType(DishType.DESSERT)
                .build());

        menuService.addItem(Dish.builder()
                .name("Kolaczki")
                .price(6)
                .cuisine(CuisineType.POLISH)
                .dishType(DishType.DESSERT)
                .build());

        menuService.addItem(Dish.builder()
                .name("Paczki")
                .price(6)
                .cuisine(CuisineType.POLISH)
                .dishType(DishType.DESSERT)
                .build());


        menuService.addItem(Drink.builder()
                .name("Wodka")
                .price(6)
                .cuisine(CuisineType.POLISH)
                .build());

        menuService.addItem(Drink.builder()
                .name("Oranzada")
                .price(6)
                .cuisine(CuisineType.POLISH)
                .build());

        menuService.addItem(Drink.builder()
                .name("Nalewka babuni")
                .price(6)
                .cuisine(CuisineType.POLISH)
                .build());

        menuService.addItem(Drink.builder()
                .name("Zubrowka")
                .price(6)
                .cuisine(CuisineType.POLISH)
                .build());

        menuService.addItem(Drink.builder()
                .name("Kompot")
                .price(6)
                .cuisine(CuisineType.POLISH)
                .build());

        menuService.addItem(Drink.builder()
                .name("Miod pitny")
                .price(6)
                .cuisine(CuisineType.POLISH)
                .build());
    }

    private void initMexican() {
        menuService.addItem(Dish.builder()
                .name("Chilaquiles")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Machaca")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Discada")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Tacos")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Burritos")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Churros")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .dishType(DishType.DESSERT)
                .build());

        menuService.addItem(Dish.builder()
                .name("Sopapilla")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .dishType(DishType.DESSERT)
                .build());

        menuService.addItem(Dish.builder()
                .name("Dulce de Leche")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .dishType(DishType.DESSERT)
                .build());

        menuService.addItem(Dish.builder()
                .name("Mangonada")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .dishType(DishType.DESSERT)
                .build());

        menuService.addItem(Dish.builder()
                .name("Tres Leches")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .dishType(DishType.DESSERT)
                .build());

        menuService.addItem(Drink.builder()
                .name("Margarita")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .build());

        menuService.addItem(Drink.builder()
                .name("Michelada")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .build());

        menuService.addItem(Drink.builder()
                .name("Paloma")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .build());

        menuService.addItem(Drink.builder()
                .name("Horchata")
                .price(6)
                .cuisine(CuisineType.MEXICAN)
                .build());
    }

    private void initItalian() {
        menuService.addItem(Dish.builder()
                .name("Pizza")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Pasta")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Polenta")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Lasagna")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Arancini")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Ravioli")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .dishType(DishType.COURSE)
                .build());

        menuService.addItem(Dish.builder()
                .name("Panna Cota")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .dishType(DishType.DESSERT)
                .build());

        menuService.addItem(Dish.builder()
                .name("Carpese")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .dishType(DishType.DESSERT)
                .build());

        menuService.addItem(Dish.builder()
                .name("Torrone")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .dishType(DishType.DESSERT)
                .build());

        menuService.addItem(Dish.builder()
                .name("Gelato")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .dishType(DishType.DESSERT)
                .build());

        menuService.addItem(Drink.builder()
                .name("Aperitivo")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .build());

        menuService.addItem(Drink.builder()
                .name("Negroni")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .build());

        menuService.addItem(Drink.builder()
                .name("Campari")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .build());

        menuService.addItem(Drink.builder()
                .name("Bellini")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .build());

        menuService.addItem(Drink.builder()
                .name("Aperol Spritz")
                .price(6)
                .cuisine(CuisineType.ITALIAN)
                .build());
    }
}
