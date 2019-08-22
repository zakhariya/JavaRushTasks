package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> map = new HashMap<>();

        map.put("Иванова", "Ира");
        map.put("Иванов", "Влад");
        map.put("Петров", "Костя");
        map.put("Петрова", "Ира");
        map.put("Петров", "Коля");
        map.put("Иванов", "Саша");
        map.put("Антонов", "Рома");
        map.put("Сикорски", "Игорь");
        map.put("Савина", "Света");
        map.put("Яковлев", "Коля");

        //при добавлении с существующим ключем - замена значения

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
