package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            arr.add(Integer.parseInt(reader.readLine()));

        int tmp;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr.get(i) < arr.get(j)){
                    tmp = arr.get(j);
                    arr.set(j, arr.get(i));
                    arr.set(i, tmp);
                }
            }
        }

        for (Integer n : arr)
            System.out.println(n);

    }
}
