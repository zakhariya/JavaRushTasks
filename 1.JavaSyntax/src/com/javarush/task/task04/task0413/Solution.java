package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(getDayByNumber(new Scanner(System.in).nextInt()));
    }

    private static String getDayByNumber(int num){
        switch (num){
            case 1 :
                return "понедельник";
            case 2 :
                return "вторник";
            case 3 :
                return "среда";
            case 4 :
                return "четверг";
            case 5 :
                return "пятница";
            case 6 :
                return "суббота";
            case 7 :
                return "воскресенье";
            default:
                return "такого дня недели не существует";
        }
    }
}