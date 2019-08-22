package com.javarush.task.task04.task0422;

/* 
18+
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        printMessage(scanner.nextLine(), scanner.nextInt());
    }

    private static void printMessage(String name, int age){
        if (age < 18)
            System.out.println("Подрасти еще");
    }
}
