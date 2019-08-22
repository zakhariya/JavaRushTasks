package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }
    // не проходит
    public static int getMinimum(List<Integer> array) {
        int min = Integer.MAX_VALUE;

        for (Integer i : array) {
            if (i <= min)
                min = i;
        }

        return min;
    }

    public static List<Integer> getIntegerList() throws NumberFormatException, IOException {
        List<Integer> integers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++)
            integers.add(Integer.parseInt(reader.readLine()));

        return integers;
    }
}
