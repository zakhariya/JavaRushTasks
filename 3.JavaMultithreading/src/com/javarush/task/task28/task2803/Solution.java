package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/

public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    public static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        return ThreadLocalRandom.current().nextLong(0, n);
    }

    public static void main(String[] args) {
        System.out.println(getRandomIntegerBetweenNumbers(0, 5));
        System.out.println(getRandomIntegerBetweenNumbers(0, 50));

        System.out.println(getRandomDouble());
        System.out.println(getRandomDouble());

        System.out.println(getRandomLongBetween0AndN(20000000000L));
        System.out.println(getRandomLongBetween0AndN(500L));
    }
}
