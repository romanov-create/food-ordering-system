package org.example.Service;

import org.example.entity.Cuisine;
import org.example.entity.Dish;
import org.example.entity.Order;
import org.example.entity.enums.TypeDish;
import org.example.repository.CuisineRepository;
import org.example.repository.DishRepository;
import org.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@ShellComponent
public class SSHCommand {

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private CuisineRepository cuisineRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostConstruct
    private void dbInit() {
//---   init cuisine   ---//
        Cuisine polish = new Cuisine("Polish", "Some description");
        Cuisine italian = new Cuisine("Italian", "Some description");
        Cuisine mexican = new Cuisine("Mexican", "Some description");

        cuisineRepository.saveAll(Arrays.asList(polish, italian, mexican));

//---   First order   ---//
        Dish burger = new Dish("burger", 12.00, polish, TypeDish.main);
        Dish cake = new Dish("cake", 8.00, italian, TypeDish.dessert);
        Dish cola = new Dish("cola", 2.50, TypeDish.drink, true, false);

        List<Dish> dishList = Arrays.asList(burger, cake, cola);

        dishRepository.saveAll(dishList);
        orderRepository.save(new Order(dishList));

//---   Second order  ---//
        Dish pizza = new Dish("pizza", 12.00, italian, TypeDish.main);
        Dish cheesecake = new Dish("cheesecake", 8.00, italian, TypeDish.dessert);
        Dish tea = new Dish("tea", 2.50, TypeDish.drink, false, true);

        List<Dish> dishList2 = Arrays.asList(pizza, cheesecake, tea);

        dishRepository.saveAll(dishList2);
        orderRepository.save(new Order(dishList2));

//---   Third order   ---//
        Dish sushi = new Dish("sushi", 12.00, polish, TypeDish.main);
        Dish cupcake = new Dish("cupcake", 8.00, mexican, TypeDish.dessert);
        Dish sprite = new Dish("sprite", 2.50, TypeDish.drink, true, false);

        List<Dish> dishList3 = Arrays.asList(sushi, cupcake, sprite);

        dishRepository.saveAll(dishList3);
        orderRepository.save(new Order(dishList3));
    }

    Logger log = Logger.getLogger(SSHCommand.class.getName());

    @ShellMethod(key = "add-cuisine", value = "add a new cuisine; parameters: [name, description]; exp.: add-cuisine Italian Some description")
    public void addCuisine(@ShellOption String name,
                           @ShellOption String description) {
        Cuisine cuisine = new Cuisine(name, description);

        cuisineRepository.save(cuisine);
        System.out.println(cuisine);
    }

    @ShellMethod(key = "create-dish", value = "create a new dish; parameters: [name, price, TypeDish[main, dessert, drink], Cuisine(optional), isIceCubes(optional), isLemon(optional) ]; example: add-dish tea 15.90 drink --ice --lemon")
    public void addDish(@ShellOption String name,
                        @ShellOption Double price,
                        @ShellOption TypeDish typeDish,
                        @ShellOption(defaultValue = ShellOption.NULL) Cuisine cuisine,
                        @ShellOption(defaultValue = ShellOption.NULL, value = "--ice") boolean isIceCubes,
                        @ShellOption(defaultValue = ShellOption.NULL, value = "--lemon") boolean isLemon) {
        Dish dish = new Dish();

        dish.setName(name);
        dish.setPrice(price);
        dish.setTypeDish(typeDish);

        dish.setCuisine(cuisine);
        dish.setIceCubes(isIceCubes);
        dish.setLemon(isLemon);

        dishRepository.save(dish);

        System.out.println(dish);
    }

    @ShellMethod(key = "place-order", value = "create a new order; parameters: [dishIdList]; exp.: place-order --id 1 2 3")
    public void placeOrder(@ShellOption(value = "--id") Long[] dishIdList) {
        List<Dish> dishList = dishRepository.findAllById(Arrays.asList(dishIdList));

        if (dishList.size() == 0) {
            throw new IllegalArgumentException("No dish found");
        }

        Order order = new Order();
        order.setDishes(dishList);

        orderRepository.save(order);
        System.out.println(order);
    }

    @ShellMethod(value = "get all cuisine")
    public void getAllCuisine() {
        List<Cuisine> cuisineList = cuisineRepository.findAll();
        cuisineList.forEach(System.out::println);
    }

    @ShellMethod(value = "get all dish")
    public void getAllDish() {
        List<Dish> dishList = dishRepository.findAll();
        dishList.forEach(System.out::println);
    }

    @ShellMethod(value = "get all order")
    public void getAllOrder() {
        List<Order> orderList = orderRepository.findAll();
        orderList.forEach(System.out::println);
    }

}