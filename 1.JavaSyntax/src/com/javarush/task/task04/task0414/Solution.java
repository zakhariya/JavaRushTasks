package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("количество дней в году: " + getDaysOfYear(new Scanner(System.in).nextInt()));
    }

    private static int getDaysOfYear(int year){
        int i = 0;
        while ((i += 4) <= year){
            if(i == year
                    && ((year % 100) > 0 || (year % 400) == 0))
                return 366;
        }

        return 365;
    }
}