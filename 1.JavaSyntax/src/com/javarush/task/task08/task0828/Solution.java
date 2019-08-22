package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Integer, String> months = new HashMap<>();

        months.put(1, "january");
        months.put(2, "february");
        months.put(3, "march");
        months.put(4, "april");
        months.put(5, "may");
        months.put(6, "june");
        months.put(7, "july");
        months.put(8, "august");
        months.put(9, "september");
        months.put(10, "october");
        months.put(11, "november");
        months.put(12, "december");

        Scanner in = new Scanner(System.in);

        String month = in.nextLine();

        for (Map.Entry pair : months.entrySet()){
            if (pair.getValue().equals(month.toLowerCase())){
                System.out.println(month + " is the " + pair.getKey() + " month");

                break;
            }
        }
    }
}
