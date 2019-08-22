package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {

    private String name, address, color;
    private int age, weight;

    public Cat(String name) {
        this.name = name;

        address = null;
        age = 1;
        weight = 1;
        color = "black";
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;

        color = "Brown";
        address = null;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;

        address = null;
        weight = 1;
        color = "unknown";
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;

        name = null;
        age = 1;
        address = null;
    }

    public Cat(int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;

        age = 1;
        name = null;
    }


    public static void main(String[] args) {

    }
}
