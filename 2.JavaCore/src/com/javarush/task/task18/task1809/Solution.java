package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());

        if (inputStream.available() > 0) {
            byte[] bytes = new byte[inputStream.available()];

            int count = inputStream.read(bytes);

            bytes = reverse(bytes);

            outputStream.write(bytes, 0, count);
        }

        outputStream.close();
        inputStream.close();
    }

    private static byte[] reverse(byte[] bytes) {
        int l = bytes.length;

        byte[] nb = new byte[l];

        for (int i = 0; i < l; i++) {
            nb[i] = bytes[l - 1 - i];
        }

        return nb;
    }
}
