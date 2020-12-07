package com.javarush.task.task29.task2913;

import java.util.LinkedList;
import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder sb = new StringBuilder(a + " ");

        while (a != b) {
            sb.append(a < b ? ++a : --a);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}