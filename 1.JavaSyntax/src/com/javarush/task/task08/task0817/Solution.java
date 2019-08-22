package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {

    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put("S1", "Name");
        map.put("S2", "Name2");
        map.put("S3", "Name");
        map.put("S4", "Name2");
        map.put("S5", "Name");
        map.put("S6", "Name33");
        map.put("S7", "Name");
        map.put("S8", "Namddde");
        map.put("S9", "Name2");
        map.put("S10", "Name");

        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> duplicates = new ArrayList<>();
        HashMap<String, String> copy = new HashMap<>(map);

        for (Map.Entry<String, String> pair : map.entrySet()){
            copy.remove(pair.getKey());
            if (copy.containsValue(pair.getValue()))
                duplicates.add(pair.getValue());
        }

        for (String firstName : duplicates)
                removeItemFromMapByValue(map, firstName);
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
//        for (String key : map.keySet())
//            System.out.println(key);
    }
}
