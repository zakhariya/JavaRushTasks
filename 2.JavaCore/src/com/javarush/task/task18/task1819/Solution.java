package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        InputStream inputStream1 = new FileInputStream(file1);

        byte[] bytes = new byte[inputStream1.available()];

        inputStream1.read(bytes);

        InputStream inputStream2 = new FileInputStream(file2);

        byte[] bytes1 = new byte[inputStream2.available()];

        inputStream2.read(bytes1);

        OutputStream outputStream = new FileOutputStream(file1);

        outputStream.write(bytes1);
        outputStream.write(bytes);

        outputStream.close();

        inputStream1.close();
        inputStream2.close();

    }
}
