package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    List<Dish> dishes = new ArrayList<>();
    List<Drink> drinks = new ArrayList<>();
    double total;
}
