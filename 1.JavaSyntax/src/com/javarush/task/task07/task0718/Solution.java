package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();

        int size = 10;

        for (int i = 0; i < size; i++)
            list.add(reader.readLine());

        for (int i = 0; i < size; i++) {
            if (i > 0
                    && list.get(i).length() <= list.get(i-1).length()){

                System.out.println(i);

                break;
            }
        }
    }
}

