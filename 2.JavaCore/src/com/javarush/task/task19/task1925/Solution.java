package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {

        String file1 = args[0];
        String file2 = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        List<String> words = new ArrayList<>();
        String line = "";

        while ((line = reader.readLine()) != null) {
            words.addAll(Arrays.asList(line.split(" ")));
        }

        String result = "";

        for (String word : words) {
            if (word.length() > 6) {
                result += word + ",";
            }
        }

        writer.write(result.substring(0, result.length() - 1));

        reader.close();
        writer.close();
    }
}
