package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = consoleReader.readLine();

        consoleReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()) {
            printReverse(fileReader.readLine());
        }

        fileReader.close();
    }

    private static void printReverse(String s) {
        int l = s.length();

        for (int i = l-1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }

        System.out.println();
    }
}
