package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;

        try {
            x = Integer.parseInt(reader.readLine());
            y = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException ex) {
            throw ex;
        }

        if (x <= 0 || y <= 0) {
            throw new NumberFormatException("Number is lower than zero");
        }

        System.out.println(getGreatestCommonFactor(x, y));
    }

    private static int getGreatestCommonFactor(int x, int y) {
        int greatestCommonFactor = 1;

        for (int i = 1; i <= x && i <= y; i++) {
            if (x % i == 0 && y % i == 0) {
                greatestCommonFactor = i;
            }
        }

        return greatestCommonFactor;
    }
}
