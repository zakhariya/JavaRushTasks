package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            arrayList.add(reader.readLine());

        arrayList.remove(2);

        int size = arrayList.size();

        for (int i = 0; i < size; i++)
            System.out.println(arrayList.get(size - (i + 1)));
    }
}


