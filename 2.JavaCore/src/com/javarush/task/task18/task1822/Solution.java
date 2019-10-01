package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(consoleReader.readLine())));

        List<String> strings = fileReader.lines().collect(Collectors.toList());

        for (String s : strings) {
            String[] params = s.split(" ");

            if (Integer.parseInt(params[0]) == Integer.parseInt(args[0])) {
                System.out.print(s);
            }
        }


        consoleReader.close();
        fileReader.close();
    }
}