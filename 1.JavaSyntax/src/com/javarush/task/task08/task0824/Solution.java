package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();

        ArrayList<Human> children = new ArrayList<>();

        children.add(new Human("Olga", false, 15, new ArrayList<>()));
        children.add(new Human("Vlad", true, 22, new ArrayList<>()));
        children.add(new Human("Ira", false, 18, new ArrayList<>()));

        Human father = new Human("Nikolai", true, 46, children);
        Human mother = new Human("Katya", false, 30, children);

        humans.add(new Human("Ira", false, 50, father));
        humans.add(new Human("Georg", true, 55, father));

        humans.add(new Human("Igor", true, 54, mother));
        humans.add(new Human("Ira", false, 49, mother));

        humans.add(father);
        humans.add(mother);

        for (Human kid : children)
            humans.add(kid);

        for (Human human : humans)
            System.out.println(human.toString());
    }

    public static class Human {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age, Human child) {
            this.name = name;
            this.sex = sex;
            this.age = age;

            ArrayList<Human> arr = new ArrayList<>();
            arr.add(child);

            this.children = arr;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();

            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);

                    text += ", " + child.name;
                }
            }

            return text;
        }
    }
}
