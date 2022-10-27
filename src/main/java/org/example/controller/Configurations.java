package org.example.controller;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Stream;

public class Configurations {
    public static final Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> readInputValuesAndReturnArray() {
        return Stream.of(new Scanner(System.in)
                        .nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .toList();
    }
}
