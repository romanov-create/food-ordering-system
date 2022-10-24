package org.example.Service;

import org.example.entity.Cuisine;
import org.example.entity.Dish;
import org.example.entity.Order;
import org.example.entity.enums.TypeDish;
import org.example.repository.CuisineRepository;
import org.example.repository.DishRepository;
import org.example.repository.OrderRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SSHCommandTest {
    @Test
    void addCuisineTest() {
        CuisineRepository cuisineRepository = mock(CuisineRepository.class);
        when(cuisineRepository.getReferenceById(1L)).thenReturn(new Cuisine(1L, "test", "test description"));

        Cuisine cuisine = cuisineRepository.getReferenceById(1L);

        assertEquals(1, cuisine.getId());
        assertEquals("test", cuisine.getName());
        assertEquals("test description", cuisine.getDescription());
    }

    @Test
    void addDishTest() {
        CuisineRepository cuisineRepository = mock(CuisineRepository.class);
        when(cuisineRepository.getReferenceById(1L)).thenReturn(new Cuisine(1L, "test", "test description"));

        Cuisine cuisine = cuisineRepository.getReferenceById(1L);

        DishRepository dishRepository = mock(DishRepository.class);
        when(dishRepository.getReferenceById(1L)).thenReturn(new Dish(1L, "test", 77.77, TypeDish.drink, true, true, cuisine, null));

        Dish dish = dishRepository.getReferenceById(1L);

        assertEquals(1, dish.getId());
        assertEquals(77.77, dish.getPrice());
        assertEquals(TypeDish.drink, dish.getTypeDish());
        assertEquals(cuisine, dish.getCuisine());
        assertTrue(dish.isIceCubes());
        assertTrue(dish.isLemon());
    }

    @Test
    void placeOrderTest() {
        CuisineRepository cuisineRepository = mock(CuisineRepository.class);
        when(cuisineRepository.getReferenceById(1L)).thenReturn(new Cuisine(1L, "test", "test description"));

        Cuisine cuisine = cuisineRepository.getReferenceById(1L);

        DishRepository dishRepository = mock(DishRepository.class);
        when(dishRepository.getReferenceById(1L)).thenReturn(new Dish(1L, "test1", 77.77, TypeDish.dessert, false, false, cuisine, null));
        when(dishRepository.getReferenceById(2L)).thenReturn(new Dish(2L, "test2", 88.77, TypeDish.drink, true, true, cuisine, null));

        Dish dish1 = dishRepository.getReferenceById(1L);
        Dish dish2 = dishRepository.getReferenceById(2L);


        OrderRepository orderRepository = mock(OrderRepository.class);
        when(orderRepository.getReferenceById(1L)).thenReturn(new Order(1L, Arrays.asList(dish1, dish2)));

        Order order = orderRepository.getReferenceById(1L);

        assertEquals(1, order.getId());
        assertEquals(2, order.getDishes().size());
    }

    @Test
    void getAllCuisineTest() {
        CuisineRepository cuisineRepository = mock(CuisineRepository.class);
        when(cuisineRepository.findAll()).thenReturn(Arrays.asList(
                new Cuisine(1L, "test1", "test description"),
                new Cuisine(2L, "test2", "test description"),
                new Cuisine(3L, "test3", "test description")
        ));

        List<Cuisine> cuisineList = cuisineRepository.findAll();

        assertEquals(3, cuisineList.size());
        assertEquals(1L, cuisineList.get(0).getId());
        assertEquals(2L, cuisineList.get(1).getId());
        assertEquals(3L, cuisineList.get(2).getId());
    }

    @Test
    void getAllDishTest() {
        CuisineRepository cuisineRepository = mock(CuisineRepository.class);
        when(cuisineRepository.getReferenceById(1L)).thenReturn(new Cuisine(1L, "test", "test description"));

        Cuisine cuisine = cuisineRepository.getReferenceById(1L);

        DishRepository dishRepository = mock(DishRepository.class);
        when(dishRepository.findAll()).thenReturn(Arrays.asList(
                new Dish(1L, "test1", 77.77, TypeDish.drink, true, true, cuisine, null),
                new Dish(2L, "test2", 77.77, TypeDish.drink, true, true, cuisine, null),
                new Dish(3L, "test3", 77.77, TypeDish.drink, true, true, cuisine, null)
        ));

        List<Dish> dishList = dishRepository.findAll();

        assertEquals(3, dishList.size());
        assertEquals(1L, dishList.get(0).getId());
        assertEquals(2L, dishList.get(1).getId());
        assertEquals(3L, dishList.get(2).getId());
    }

    @Test
    void getAllOrderTest() {
        CuisineRepository cuisineRepository = mock(CuisineRepository.class);
        when(cuisineRepository.getReferenceById(1L)).thenReturn(new Cuisine(1L, "test", "test description"));

        Cuisine cuisine = cuisineRepository.getReferenceById(1L);

        DishRepository dishRepository = mock(DishRepository.class);
        when(dishRepository.getReferenceById(1L)).thenReturn(new Dish(1L, "test1", 77.77, TypeDish.dessert, false, false, cuisine, null));
        when(dishRepository.getReferenceById(2L)).thenReturn(new Dish(2L, "test2", 88.77, TypeDish.drink, true, true, cuisine, null));

        Dish dish1 = dishRepository.getReferenceById(1L);
        Dish dish2 = dishRepository.getReferenceById(2L);

        List<Dish> dishList = Arrays.asList(dish1, dish2);

        OrderRepository orderRepository = mock(OrderRepository.class);
        when(orderRepository.findAll()).thenReturn(Arrays.asList(
                new Order(1L, dishList),
                new Order(2L, dishList),
                new Order(3L, dishList)
        ));

        List<Order> orderList = orderRepository.findAll();

        assertEquals(3, orderList.size());
        assertEquals(1L, orderList.get(0).getId());
        assertEquals(2L, orderList.get(1).getId());
        assertEquals(3L, orderList.get(2).getId());
    }
}