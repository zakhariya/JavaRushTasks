package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String fileFirst = consoleReader.readLine();

        consoleReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileFirst));

        List<String> words = new ArrayList<>();
        String line = "";

        while ((line = fileReader.readLine()) != null) {
            words.addAll(Arrays.asList(line.split("\\s")));
            words.add("\n");
        }

        fileReader.close();

        replaceNumbers(words);

        System.out.println(replaceChars(words.toString()));
    }

    private static void replaceNumbers(List<String> words) {
        int length = words.size();

        for (int i = 0; i < length; i++) {
            String word = words.get(i);

            if (word.matches("\\d+")) {
                int n = Integer.parseInt(word);

                if (map.containsKey(n)) {
                    words.set(i, map.get(n));
                }
            }
        }
    }

    private static String replaceChars(String s) {
        return s.replaceAll("(,\\s)", " ")
                .replaceAll("(\\[|\\])", "")
                .replaceAll("\n ", "\n");
    }
}
