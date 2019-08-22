package com.javarush.task.task05.task0527;

/* 
Том и Джерри
*/

public class Solution {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);

        Cat tomCat = new Cat("Tom", 50, false);

        Dog someDog = new Dog("just a dog", 75, true);
    }

    public static class Cat {
        private String name;
        double hitPoints;
        boolean isAngry;

        public Cat(String name, double hitPoints, boolean isAngry) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.isAngry = isAngry;
        }
    }

    public static class Dog {
        private String name;
        double hitPoints;
        boolean isAngry;

        public Dog(String name, double hitPoints, boolean isAngry) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.isAngry = isAngry;
        }
    }

    public static class Mouse {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail) {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //напишите тут ваш код
}
