package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        printMess(num);
    }

    private static void printMess(int num){
        String msg = "";

        if(num < 0 && -num % 2 > 0)
            msg = "отрицательное нечетное число";
        else if(num < 0 && num % 2 == 0)
            msg = "отрицательное четное число";
        else if(num == 0)
            msg = "ноль";
        else if (num > 0 && num % 2 > 0)
            msg = "положительное нечетное число";
        else if (num > 0 && num % 2 == 0)
            msg = "положительное четное число";


        System.out.println(msg);
    }
}
