package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        printNamesInfo(new String[]{scanner.nextLine(), scanner.nextLine()});
    }

    private static void printNamesInfo(String[] names){
        if(names[0].equals(names[1]))
            System.out.println("Имена идентичны");
        else if(names[0].length() == names[1].length())
            System.out.println("Длины имен равны");
    }
}
