package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            move();
            print();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double max = 0;
        Horse winner = null;

        for (Horse horse : horses) {
            if (horse.getDistance() > max) {
                winner = horse;
            }
        }

        return winner;
    }

    public void printWinner() {
        Horse winner = getWinner();

        System.out.println("Winner is " + winner.getName() + "!");
    }

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();

        Horse hOne = new Horse("Gdfgdfg", 3, 0);
        Horse hTwo = new Horse("JKfhjjk", 3, 0);
        Horse hThree = new Horse("Opdfj", 3, 0);

        horses.add(hOne);
        horses.add(hTwo);
        horses.add(hThree);

        game = new Hippodrome(horses);

        game.run();
        game.printWinner();
    }
}
