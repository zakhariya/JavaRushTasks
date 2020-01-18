package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileReader = new FileReader(reader.readLine());

        reader.close();

        String s = "";

        while (fileReader.ready()) {
            s += (char) fileReader.read();
        }

        fileReader.close();

        Pattern pattern = Pattern.compile("\\s*(\\s|,|\\.|!|\\?|;|:)\\s*");
        String[] words = pattern.split(s);

        int count = 0;

        for (String word : words) {
            if (word.equals("world")) {
                count++;
            }
        }

        System.out.println(count);
    }
}
