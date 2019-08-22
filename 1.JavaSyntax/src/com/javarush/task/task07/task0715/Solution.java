package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();

        list.add("мама");
        list.add("мыла");
        list.add("раму");

        for (int i = 0; i < 3; i++){
            int size = list.size();

            list.add((size + i) - 2, "именно");
        }

        for (String s : list)
            System.out.println(s);
    }
}
