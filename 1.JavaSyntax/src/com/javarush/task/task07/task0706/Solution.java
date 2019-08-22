package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[15];
        int evenSum = 0, oddSum = 0;

        for (int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();

        for (int i = 0; i < arr.length; i++) {
            if(i % 2 == 0)
                evenSum += arr[i];
            else
                oddSum += arr[i];
        }

        if (evenSum > oddSum)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
