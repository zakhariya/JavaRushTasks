package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("S4", 800);
        map.put("S2", 550);
        map.put("S3", 500);
        map.put("S5", 300);
        map.put("S6", 350);
        map.put("S7", 250);
        map.put("S8", 150);
        map.put("S9", 40);
        map.put("S1", 0);
        map.put("S10", 10);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> copy = new HashMap<>(map);

        for (Map.Entry<String, Integer> pair : copy.entrySet())
            if (pair.getValue() < 500)
                map.remove(pair.getKey());
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);
//        for (String key : map.keySet())
//            System.out.println(key);
    }
}
