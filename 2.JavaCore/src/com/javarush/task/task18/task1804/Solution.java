package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);

        Map<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;

        while (inputStream.available() > 0) {
            int b = inputStream.read();

            if (!map.containsKey(b)) {
                map.put(b, 1);
            } else {
                int n = map.get(b);

                map.put(b, ++n);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();

            min = val < min ? val : min;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();

            if (val == min) {
                System.out.printf("%d ", entry.getKey());
            }
        }

        reader.close();
        inputStream.close();
    }
}
