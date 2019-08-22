package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        ArrayList<Human> humans = new ArrayList<>();

        humans.add(new Human("Володя", true, 63));
        humans.add(new Human("Маша", false, 58));
        humans.add(new Human("Коля", true, 60));
        humans.add(new Human("Ира", false, 55));
        humans.add(new Human("Саша", true, 33, humans.get(0), humans.get(1)));
        humans.add(new Human("Лена", false, 27, humans.get(2), humans.get(3)));
        humans.add(new Human("Фарух", true, 8, humans.get(4), humans.get(5)));
        humans.add(new Human("Оля", false, 6, humans.get(4), humans.get(5)));
        humans.add(new Human("Карина", false, 3, humans.get(4), humans.get(5)));

        for (Human human : humans)
            System.out.println(human.toString());
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;

        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}