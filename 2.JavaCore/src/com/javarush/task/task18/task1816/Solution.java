package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        InputStream stream = new FileInputStream(fileName);

        int count = 0;

        while (stream.available() > 0) {
            int b = stream.read();

            if (b >= 65 && b <= 90
                    || b >= 97 && b <= 122) {

                count++;
            }
        }

        System.out.println(count);

        stream.close();
    }
}
