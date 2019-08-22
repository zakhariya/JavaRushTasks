package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> array = new ArrayList<>();

        int minLength = 0;

        for (int i = 0; i < 5; i++) {
            String s = reader.readLine();

            if (i == 0){
                minLength = s.length();
            }else {
                int length = s.length();

                if (length < minLength)
                    minLength = length;
            }

            array.add(s);
        }

        for (String s : array)
            if (s.length() == minLength)
                System.out.println(s);
    }
}
