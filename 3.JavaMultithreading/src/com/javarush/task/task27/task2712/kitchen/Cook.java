package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    private final String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(10);

                if (!queue.isEmpty()) {
                    if (!isBusy()) {
                        startCookingOrder(queue.take());
                    }
                }
            }
        } catch (InterruptedException e) {
        }
    }

    public void startCookingOrder(Order order) {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order);

        setChanged();
        notifyObservers(order);

        int timeMinutes = order.getTotalCookingTime();

        CookedOrderEventDataRow row =
                new CookedOrderEventDataRow(order.getTablet().toString(), name, timeMinutes * 60, order.getDishes());

        StatisticManager.getInstance().register(row);

        try {
            Thread.sleep(timeMinutes * 10);
        } catch (InterruptedException e) {
        }

        busy = false;
    }

    public boolean isBusy() {
        return busy;
    }

    public LinkedBlockingQueue<Order> getQueue() {
        return queue;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return name;
    }
}
