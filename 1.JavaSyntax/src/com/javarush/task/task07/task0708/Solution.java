package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        strings = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            strings.add(reader.readLine());

        int size = strings.size();
        int maxLength = 0;

        for (int i = 0; i < size; i++) {
            int l = strings.get(i).length();

            if(l > maxLength)
                maxLength = l;
        }

        for (String s : strings)
            if (s.length() == maxLength)
                System.out.println(s);
    }
}
