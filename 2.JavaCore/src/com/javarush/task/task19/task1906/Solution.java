package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String firstFile = consoleReader.readLine();
        String secondFile = consoleReader.readLine();

        consoleReader.close();

        FileReader fileReader = new FileReader(firstFile);
        FileWriter fileWriter = new FileWriter(secondFile);

        for (int i = 1; fileReader.ready(); i++) {
            int c = fileReader.read();

            if (i % 2 == 0) {
                fileWriter.write(c);
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
