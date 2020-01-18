package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstFile = reader.readLine();
        String secondFile = reader.readLine();

        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(firstFile));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFile));

        String text = "";

        while (fileReader.ready()) {
            text += (char) fileReader.read();
        }

        String[] words = text.split(" |\r|\n");

        List<String> numbersList = new ArrayList<>();

        for (String word : words) {
            if (isNumber(word)) {
                numbersList.add(word);
            }
        }

        String numbers = numbersList.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");

        for (int i = 0; i < numbers.length(); i++) {
            fileWriter.write(numbers.charAt(i));
        }

        fileReader.close();
        fileWriter.close();
    }

    private static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.') {
                return false;
            }
        }

        return true;
    }
}
