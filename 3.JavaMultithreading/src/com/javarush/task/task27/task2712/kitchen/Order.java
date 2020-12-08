package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        ConsoleHelper.writeMessage(toString());
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public int getTotalCookingTime() {
        int time = 0;

        for (Dish dish : dishes) {
            time += dish.getDuration();
        }

        return time;
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) {
            return "";
        }

        return "Your order: " + dishes + " of "
                + tablet.toString() + ", cooking time "
                + getTotalCookingTime() + "min";
    }
}
