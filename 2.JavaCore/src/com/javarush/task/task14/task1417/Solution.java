package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");

        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;
        private List<Money> allMoney;


        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();

            this.allMoney.add(new Hrivna(250.35));
            this.allMoney.add(new USD(3500));
            this.allMoney.add(new Ruble(100.5));
        }

        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
