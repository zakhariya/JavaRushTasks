package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextInt())
            System.out.print(printNumber(scanner.nextInt()));
        else
            System.out.println("findПожалуйстаByNameLike();");

    }

    private static int printNumber(int number){
        if(number < 0)
            return ++number;
        else if(number > 0)
            return number * 2;

        return 0;
    }

}