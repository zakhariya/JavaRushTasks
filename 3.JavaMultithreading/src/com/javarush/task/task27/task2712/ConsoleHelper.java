package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private ConsoleHelper() {
    }

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();

        writeMessage(Dish.allDishesToString());

        String dish = "";

        while (true) {
            writeMessage("Введите название блюда, или exit для завершения заказа:");
            dish = readString().toUpperCase().trim();

            if (dish.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                dishes.add(Dish.valueOf(dish));
                writeMessage("Блюдо добавлено в заказ. " + dishes);
            } catch (IllegalArgumentException e) {
                writeMessage("Такого ублюда нет в меню.");
            }
        }

        return dishes;
    }
}