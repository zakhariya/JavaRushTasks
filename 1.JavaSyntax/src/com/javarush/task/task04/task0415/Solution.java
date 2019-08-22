package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int a = 0, b = 0, c = 0;

        if(scanner.hasNextInt())
            a = scanner.nextInt();
        if(scanner.hasNextInt())
            b = scanner.nextInt();
        if(scanner.hasNextInt())
            c = scanner.nextInt();

        System.out.println(printIsTringleCanBeСуществующий(a, b, c));
    }

    private static String printIsTringleCanBeСуществующий(int a, int b, int c){
        if(c >= (a + b)
                || b >= (a + c)
                || a >= (b + c))
            return "Треугольник не существует.";

        return "Треугольник существует.";
    }
}