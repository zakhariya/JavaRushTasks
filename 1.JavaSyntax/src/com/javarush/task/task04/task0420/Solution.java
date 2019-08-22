package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        printOrderedNums(new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()});
    }

    private static void printOrderedNums(int [] nums){
        int maxVal = 0;
        int lastIdx = 0;
        int l = nums.length;

        for (int i=0; i<l; i++){
            maxVal = nums[i];

            for (int j=0; j<l; j++){
                if(nums[j] >= maxVal && j >= i){
                    maxVal = nums[j];
                    lastIdx = j;
                }
            }

            nums[lastIdx] = nums[i];
            nums[i] = maxVal;

            System.out.print(nums[i] + " ");
        }
    }
}
