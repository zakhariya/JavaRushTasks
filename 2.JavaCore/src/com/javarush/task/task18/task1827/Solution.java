package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileName, true));


    }
}
