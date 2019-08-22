package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int[] bigArr = new int[20];
        int[] one = new int[10];
        int[] two = new int[10];

        for (int i = 0; i < bigArr.length; i++)
            bigArr[i] = scanner.nextInt();

        for (int i = 0; i < bigArr.length; i++) {
            if (i < one.length)
                one[i] = bigArr[i];
            else
                two[i - one.length] = bigArr[i];
        }

        for (int n : two)
            System.out.println(n);
    }
}
