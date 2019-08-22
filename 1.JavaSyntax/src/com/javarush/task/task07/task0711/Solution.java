package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> arrayList = new ArrayList<>();

        int size = 5;

        for (int i = 0; i < size; i++)
            arrayList.add(reader.readLine());

        for (int i = 0; i < 13; i++) {
            String thumb = arrayList.get(size - 1);

            arrayList.remove(size - 1);
            arrayList.add(0, thumb);
        }

        for (String s : arrayList)
            System.out.println(s);
    }
}
