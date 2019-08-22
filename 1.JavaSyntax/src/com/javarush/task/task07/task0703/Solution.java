package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = new String[10];
        int[] intArr = new int[10];

        for (int i = 0; i < 10; i++) {
            strArr[i] = reader.readLine();
            intArr[i] = strArr[i].length();
        }

        for(int n : intArr)
            System.out.println(n);
    }
}
