package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text;

        while (!(text = reader.readLine()).equals("exit")) {
            if (text.contains(".") && isDouble(text)) {
                print(Double.valueOf(text));
            } else if (isShort(text)) {
                print(Short.valueOf(text));
            } else if (isInteger(text)) {
                print(Integer.valueOf(text));
            } else {
                print(text);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }

    private static boolean isDouble(String text) {
        try {
            Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private static boolean isShort(String text) {
        try {
            int n = Integer.parseInt(text);
            if (n <= 0 || n >= 128) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private static boolean isInteger(String text) {
        try {
            int n = Integer.parseInt(text);

            if (n > 0 && n < 128) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
