package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        printMaxNum(new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()});
    }

    private static void printMaxNum(int [] nums){
        int max = nums[0];

        for (int i : nums){
            if(i >= max)
                max = i;
        }

        System.out.println(max);
    }
}
