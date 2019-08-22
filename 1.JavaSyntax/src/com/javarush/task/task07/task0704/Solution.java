package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[arr.length - (i + 1)]);
        }
    }
}

