package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length < 4 || !args[0].equals("-c")) {
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));

        List<String> lines = fileReader.lines().collect(Collectors.toList());

        int id = Integer.parseInt(lines.get(lines.size() - 1).substring(0, 8).replaceAll(" ", ""));

        String newId = addSpaces(String.valueOf(++id), 8);
        String name = addSpaces(args[1], 30);
        String price = addSpaces(args[2], 8);
        String quantity = addSpaces(args[3], 4);

        fileWriter.newLine();
        fileWriter.write(newId + name + price + quantity);

        reader.close();
        fileReader.close();
        fileWriter.close();
    }

    private static String addSpaces(String s, int count) {
        while (s.length() < count) {
            s += " ";
        }

        return s;
    }
}