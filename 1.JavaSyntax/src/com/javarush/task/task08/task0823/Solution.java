package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Омовение Рамы
*/

public class Solution  {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char[] chars = s.toCharArray();

        int size = chars.length;

        for (int i = 0; i < size; i++) {
            if (chars[i] == ' ' && i + 1 < size)
                chars[i + 1] = String.valueOf(chars[i + 1]).toUpperCase().charAt(0);
            else
                if (i == 0)
                    chars[i] = String.valueOf(chars[i]).toUpperCase().charAt(0);

        }

        System.out.println(String.valueOf(chars));
    }
}
