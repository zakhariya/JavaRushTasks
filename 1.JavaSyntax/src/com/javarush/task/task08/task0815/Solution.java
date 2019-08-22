package com.javarush.task.task08.task0815;

import java.util.HashMap;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put("S1", "N1");
        map.put("S22", "N1");
        map.put("S23", "N2");
        map.put("S2", "N3");
        map.put("S3", "N4");
        map.put("S4", "N5");
        map.put("S5", "N5");
        map.put("S6", "N6");
        map.put("S7", "N7");
        map.put("S8", "N8");

        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;

        for (String firstName : map.values())
            if (firstName.equals(name))
                count++;

        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;

        for (String key : map.keySet())
            if (key.equals(lastName))
                count++;

        return count;
    }

    public static void main(String[] args) {

    }
}
