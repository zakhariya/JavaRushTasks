package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.util.List;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String surname;
        private boolean sex;
        private int age;
        private Human partner;
        private List<Human> children;

        public Human() {

        }

        public Human(boolean sex) {
            this.sex = sex;
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public Human(String name, String surname, boolean sex) {
            this.name = name;
            this.surname = surname;
            this.sex = sex;
        }

        public Human(String name, String surname, boolean sex, int age) {
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, String surname, boolean sex, Human partner) {
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.partner = partner;
        }

        public Human(String name, String surname, boolean sex, int age, Human partner) {
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.age = age;
            this.partner = partner;
        }

        public Human(String name, String surname, boolean sex, int age, List<Human> children) {
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, String surname, boolean sex, int age, Human partner, List<Human> children) {
            this.name = name;
            this.surname = surname;
            this.sex = sex;
            this.age = age;
            this.partner = partner;
            this.children = children;
        }
    }
}
