package com.javarush.task.task20.task2025;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/*
Алгоритмы-числа
*/
public class Solution {
    private static long[][] pows = new long[10][20];
    private static long maxVal;
    private static byte maxPow;
    private static long count;
    private static Set<Long> armstrongSet = new TreeSet<>();

    //TODO: remove
    private static long maxSum;
    private static long maxV;

    static {
        for (int i = 0; i < pows.length; i++) {
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = (long) Math.pow(i, j);
            }
        }
    }

    public static void main(String[] args) {
        long start = new Date().getTime();
        long value = Long.MAX_VALUE;

        long[] numbers = getNumbers(value);
        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();


        System.out.println((new Date().getTime() - start) + " millis, " + memory/1048576 + " Mb" );
        System.out.println(count + " numbers checked of " + value);
        System.out.println("******************");


        System.out.println("Found number of armstrong - " + numbers.length);

        for (long number : numbers) {
            System.out.println(number);
        }

        System.out.println(maxSum + " - max sum");
        System.out.println(maxV + " - max v");
    }

    public static long[] getNumbers(long N) {

//        if (N < Long.MAX_VALUE) {
//
//        }

        maxVal = N;
        maxPow = getCountsOfDigits(N);

        armstrongSet.clear();
        generateNums(1, (byte) 1);

        long[] result = new long[armstrongSet.size()];
        int i = 0;

        for (long n : armstrongSet) {
            result[i++] = n;
        }

        return result;
    }

    private static void generateNums(long x, byte pow) {

        count++;

        while (true) {
            long sum = 0;
            byte y;
            long n = x;

            while (n > 0) {
                y = (byte) (n % 10);
                sum += pows[y][pow];

//                if (sum < 0 || sum > maxVal) {
//                    return;
//                }

                if (x == 9223000000000000000L) {
                    System.out.println("sdsdsdsdd");
                }
//                9223372036854775807

                //TODO: remove
                if (sum > maxSum) {
                    maxSum = sum;
                }
                if (x > maxV) {
                    maxV = x;
                }

                n /= 10;

            }

            if (getCountsOfDigits(sum) == pow
                    && isArmstrong(sum, pow)) {

                armstrongSet.add(sum);
            }

            if (!isNumberUnique(x)) {
                break;
            } else if (x < maxVal && pow < maxPow) {
                generateNums(x * 10, (byte) (pow + 1));
            }

            x++;
        }
    }

    private static boolean isArmstrong(long num, byte pow) {
        long sum = 0;
        byte y;
        long n = num;

        while (n > 0) {
            y = (byte) (n % 10);
            sum += pows[y][pow];

            n /= 10;
        }

        return sum == num;
    }

    private static boolean isNumberUnique(long number) {
        long last = number % 10;
        long n = number / 10;
        long prev = n % 10;

        return (n == 0) ? true : last <= prev;
    }

    public static byte getCountsOfDigits(long number) {
        return (number == 0) ? 1 : (byte) Math.ceil(Math.log10(Math.abs(number) + 0.5));
    }
}
