package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(args[0]), 1800000);

        byte[] bytes = new byte[bis.available()];

        bis.read(bytes);

        Map<Integer, Integer> map = new TreeMap<>();

        for (int n : bytes) {
            if (map.containsKey(n)) {
                int count = map.get(n);
                map.put(n, ++count);
            } else {
                map.put(n, 1);
            }
        }

        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            System.out.println(String.format("%s %d", (char) set.getKey().intValue(), set.getValue()));
        }

        bis.close();
    }
}
