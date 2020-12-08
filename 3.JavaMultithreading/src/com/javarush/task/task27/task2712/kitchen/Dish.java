package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
    FISH,
    STEAK,
    SOUP,
    JUICE,
    WATER;

    public static String allDishesToString() {
        return Arrays.asList(values()).toString().replaceAll("\\[|\\]", "");
    }
}
