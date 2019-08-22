package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int[] nums = new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};

        printMessage(nums);
    }

    private static void printMessage(int[] nums){
        int posCount = 0;
        int negCount = 0;

        for(int num : nums){
            if(num > 0)
                posCount++;
            else if (num < 0)
                negCount++;
        }


        System.out.println("количество отрицательных чисел: " + negCount);
        System.out.println("количество положительных чисел: " + posCount);
    }
}
