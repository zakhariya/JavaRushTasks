package com.javarush.task.task19.task1909;

/* 
Замена знаков
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

        while (fileReader.ready()) {
            char c = (char) fileReader.read();

            if (c == '.') {
                c = '!';
            }

            fileWriter.write((int) c);
        }

        fileReader.close();
        fileWriter.close();
    }
}
