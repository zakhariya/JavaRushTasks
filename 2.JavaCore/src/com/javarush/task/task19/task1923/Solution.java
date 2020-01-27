package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        List<String> wordList = new ArrayList<>();

        String line = "";

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s");

            for (String word : words) {
                if (Pattern.matches("(.*\\d+.*)", word)) {
                    wordList.add(word);
                }
            }
        }

        writer.write(removeChars(wordList.toString()));

        reader.close();
        writer.close();
    }

    private static String removeChars(String s) {
        return s.replaceAll("[\\[,\\]]", "");
    }
}