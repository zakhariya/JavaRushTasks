package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        if(weight * strength / age >
                anotherCat.weight * anotherCat.strength / anotherCat.age)
            return true;

        return false;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.weight = 5;
        cat1.strength = 5;
        cat1.age = 6;

        Cat cat2 = new Cat();
        cat2.weight = 5;
        cat2.strength = 5;
        cat2.age = 7;

        System.out.println(cat1.fight(cat2) + " " + cat2.fight(cat1));
    }
}
