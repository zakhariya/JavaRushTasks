package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());

        if(num >= 1 && num <= 999)
            System.out.println(getMessage(num));
    }

    private static String getMessage(int num){
        String msg = "";
        int l = String.valueOf(num).length();

        if(num % 2 > 0)
            msg += "нечетное ";
        else
            msg += "четное ";

        if (l == 1)
            msg += "одно";
        else if (l == 2)
            msg += "дву";
        else
            msg += "трех";


        return msg + "значное число";
    }
}
