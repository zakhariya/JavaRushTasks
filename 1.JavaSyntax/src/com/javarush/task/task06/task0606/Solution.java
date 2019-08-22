package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String stringNumber = bufferedReader.readLine();

        try {
            countEvenAndOdd(stringNumber);
        } catch (NumberFormatException e) {
            // insert number, please
        }

        System.out.println("Even: " + even + " Odd: " + odd);
    }

    private static void countEvenAndOdd(String stringNumbers) throws NumberFormatException{
        even = 0;
        odd = 0;

        char[] chars = stringNumbers.toCharArray();

        for (char ch : chars){
            int number = Integer.parseInt(String.valueOf(ch));

            if (number % 2 > 0)
                odd++;
            else
                even++;
        }
    }
}
