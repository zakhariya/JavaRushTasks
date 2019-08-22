package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        char[] arr = String.valueOf(number).toCharArray();
        int summ = 0;

        for(char c : arr)
            summ += Integer.parseInt(String.valueOf(c));

        return summ;
    }
}