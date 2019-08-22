package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int[] nums = new int[]{scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};

        if(checkForDuplicates(nums))
            System.out.println(getUniqueNum(nums));
    }

    private static int getUniqueNum(int[] nums){
        int l = nums.length;
        int unIdx = 0;

        for(int i=0; i<l; i++){
            unIdx = i + 1;
            for(int j=0; j<l; j++){
                if (i != j && nums[i] == nums[j])
                    unIdx = 0;
            }
            if (unIdx > 0)
                return unIdx;
        }

        return 0;
    }

    private static boolean checkForDuplicates(int[] nums){
        int l = nums.length;

        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++){
                if (i != j && nums[i] == nums[j])
                    return true;
            }
        }

        return false;
    }
}
