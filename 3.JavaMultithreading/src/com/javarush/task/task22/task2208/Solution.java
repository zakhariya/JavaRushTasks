package com.javarush.task.task22.task2208;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();

        if(Collections.frequency(params.values(), null) == params.size()) {
            return "";
        }

        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                stringBuilder.append(pair.getKey() + " = \'"+ pair.getValue() + "\' and ");
            }
        }

        return stringBuilder.toString().substring(0, stringBuilder.lastIndexOf(" and "));
    }
}
