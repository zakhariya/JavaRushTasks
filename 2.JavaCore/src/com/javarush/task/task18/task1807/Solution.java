package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        InputStream inputStream = new FileInputStream(fileName);

        int count = 0;

        char character = ',';
        int ascii = (int) character;

        while (inputStream.available() > 0) {
            int b = inputStream.read();

            if (ascii == b) {
                count++;
            }
        }

        System.out.println(count);

        reader.close();
        inputStream.close();
    }
}
