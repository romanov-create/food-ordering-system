//package org.example.Service;
//
//import org.example.entity.Cuisine;
//import org.example.entity.Dish;
//import org.example.entity.Drink;
//import org.example.entity.Order;
//import org.example.entity.enums.TypeDish;
//import org.testng.annotations.Test;
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.logging.Logger;
//
//import static org.testng.AssertJUnit.assertFalse;
//import static org.testng.AssertJUnit.assertTrue;
//
//public class SSHCommand {
//
//
//
//
//    Logger log = Logger.getLogger(SSHCommand.class.getName());
//
//    //    @ShellMethod(key = "add-cuisine", value = "add a new cuisine; parameters: [name, description]; exp.: add-cuisine Italian Some description")
//    public void addCuisine(String name, String description) {
//        Cuisine cuisine = new Cuisine(name, description);
////        cuisineRepository.save(cuisine);
//        System.out.println(cuisine);
//    }
//
//    //    @ShellMethod(key = "create-dish", value = "create a new dish; parameters: [name, price, TypeDish[main, dessert, drink], Cuisine(optional), isIceCubes(optional), isLemon(optional) ]; example: add-dish tea 15.90 drink --ice --lemon")
//    public void addDish(String name,
//                        Double price,
//                        TypeDish typeDish,
//                        Cuisine cuisine,
//                        boolean isIceCubes,
//                        boolean isLemon) {
//        Dish dish = new Dish();
//
//        dish.setName(name);
//        dish.setPrice(price);
//        dish.setTypeDish(typeDish);
//
//        dish.setCuisine(cuisine);
//        dish.setIceCubes(isIceCubes);
//        dish.setLemon(isLemon);
//
////        dishRepository.save(dish);
//
//        System.out.println(dish);
//    }
//    public void addDrink(String name,
//                        Double price,
//                        Cuisine cuisine,
//                        boolean isIceCubes,
//                        boolean isLemon) {
//        Drink drink = new Drink();
//
//        drink.setName(name);
//        drink.setPrice(price);
//
//        drink.setCuisine(cuisine);
//        drink.setIceCubes(isIceCubes);
//        drink.setLemon(isLemon);
//
////        dishRepository.save(drink);
//
//        System.out.println(drink);
//    }
//
//
////    @ShellMethod(key = "place-order", value = "create a new order; parameters: [dishIdList]; exp.: place-order --id 1 2 3")
//    public void placeOrder(Long[] dishIdList) {
////        List<Dish> dishList = dishRepository.findAllById(Arrays.asList(dishIdList));
////
////        if (dishList.size() == 0) {
////            throw new IllegalArgumentException("No dish found");
////        }
////
////        Order order = new Order();
////        order.setDishes(dishList);
////
////        orderRepository.save(order);
////        System.out.println(order);
//    }
//
////    @ShellMethod(value = "get all cuisine")
//    public void getAllCuisine() {
////        List<Cuisine> cuisineList = cuisineRepository.findAll();
////        cuisineList.forEach(System.out::println);
//    }
//
////    @ShellMethod(value = "get all dish")
//    public void getAllDish() {
////        List<Dish> dishList = dishRepository.findAll();
////        dishList.forEach(System.out::println);
//    }
//
////    @ShellMethod(value = "get all order")
//    public void getAllOrder() {
////        List<Order> orderList = orderRepository.findAll();
////        orderList.forEach(System.out::println);
//    }
//
//}