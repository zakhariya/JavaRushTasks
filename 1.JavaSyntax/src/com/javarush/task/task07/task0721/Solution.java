package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int length = 20;

        int[] ints = new int[20];

        int maximum = 0;
        int minimum = 0;

        for (int i = 0; i < length; i++) {
            int number = Integer.parseInt(reader.readLine());

            if (i == 0){
                maximum = number;
                minimum = number;
            }

            ints[i] = number;

            if (number >= maximum)
                maximum = number;
            if (number <= minimum)
                minimum = number;
        }

        System.out.print(maximum + " " + minimum);
    }
}
