package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        printNums(scanner.nextInt(), scanner.nextInt());
    }
    private static void printNums(int a, int b){
        if(a <= b)
            System.out.println(a);
        else
            System.out.println(b);
    }
}