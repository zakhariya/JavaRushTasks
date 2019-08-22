package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int[] nums = new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};

        System.out.println(getPositiveNumsCount(nums));
    }

    private static int getPositiveNumsCount(int[] nums){
        int count = 0;

        for(int num : nums)
            if(num > 0)
                count++;

        return count;
    }
}
