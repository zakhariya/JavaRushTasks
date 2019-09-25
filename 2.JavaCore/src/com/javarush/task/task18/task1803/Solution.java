package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);

        Map<Integer, Integer> map = new HashMap<>();

        int max = 2;

        while (inputStream.available() > 0) {
            int b = inputStream.read();

            if (!map.containsKey(b)) {
                map.put(b, 1);
            } else {
                int n = map.get(b);

                max = ++n > max ? n : max;

                map.put(b, n);
            }
        }

        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            int val = set.getValue();

            if (val == max) {
                System.out.printf("%s ", set.getKey());
            }
        }

        reader.close();
        inputStream.close();
    }
}
