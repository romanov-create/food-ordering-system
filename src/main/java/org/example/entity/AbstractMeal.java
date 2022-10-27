package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.entity.enums.CuisineType;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AbstractMeal {
    private String name;
    private double price;
    private CuisineType cuisine;
}
