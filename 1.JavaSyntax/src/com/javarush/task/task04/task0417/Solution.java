package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        printNumbers(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    }

    private static void printNumbers(int a, int b, int c){
        if(a == b && a == c)
            System.out.println(a + " " + b + " " + c);
        else if(a == b)
            System.out.println(a + " " + b);
        else if(a == c)
            System.out.println(a + " " + c);
        else if(b == c)
            System.out.println(b + " " + c);
    }
}