package com.javarush.task.task27.task2712.kitchen;

import java.util.Arrays;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        return Arrays.asList(values()).toString().replaceAll("\\[|\\]", "");
    }

    public int getDuration() {
        return duration;
    }
}
