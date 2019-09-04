package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String query = new URL(reader.readLine()).getQuery();
        String[] pairs = query.split("&");

        List<String> keys = new ArrayList<>();
        String objParam = "";

        for (int i = 0; i < pairs.length; i++) {
            String pair = pairs[i];
            String key = "";

            if (pair.contains("=")) {
                key = pairs[i].substring(0, pairs[i].indexOf('='));
            } else {
                key = pair;
            }

            keys.add(key);

            if (key.equals("obj")) {
                objParam = pairs[0].substring(pairs[0].indexOf('=') + 1);
            }
        }

        System.out.println(String.join(" ", keys));

        if (objParam.length() == 0) {
            return;
        }

        try {
            alert(Double.parseDouble(objParam));
        } catch (Exception e) {
            alert(objParam);
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
