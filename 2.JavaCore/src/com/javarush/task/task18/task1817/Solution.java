package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream stream = new FileInputStream(args[0]);

        int spaces = 0;
        int symbols = 0;

        while (stream.available() > 0) {
            int b = stream.read();

            if (b == 32) {
                spaces++;
                symbols++;
            } else {
                symbols++;
            }
        }

        double result = (double) spaces / symbols * 100;

        System.out.println(new DecimalFormat("#0.00").format(result).replace(",", "."));

        stream.close();
    }
}
