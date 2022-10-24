package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.enums.TypeDish;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private TypeDish typeDish;

    private boolean iceCubes;
    private boolean lemon;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cuisine cuisine;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Order> orders;

    public Dish(String name, double price, Cuisine cuisine, TypeDish typeDish) {
        this.name = name;
        this.price = price;
        this.cuisine = cuisine;
        this.typeDish = typeDish;
    }

    public Dish(String name, double price, TypeDish typeDish, boolean iceCubes, boolean lemon) {
        this.name = name;
        this.price = price;
        this.typeDish = typeDish;
        this.iceCubes = iceCubes;
        this.lemon = lemon;
    }
}
