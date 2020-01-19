package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstFile = reader.readLine();
        String secondFile = reader.readLine();

        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(firstFile));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(secondFile));

        String s = "";

        while (fileReader.ready()) {
            s += (char) fileReader.read();
        }

        s = s.replaceAll("\\p{Punct}", "");

        for (char c : s.toCharArray()) {
            fileWriter.write((int) c);
        }

        fileReader.close();
        fileWriter.close();
    }
}
