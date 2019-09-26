package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OutputStream outputStream = new FileOutputStream(reader.readLine());
        InputStream inputStream1 = new FileInputStream(reader.readLine());
        InputStream inputStream2 = new FileInputStream(reader.readLine());

        if (inputStream1.available() > 0) {
            byte[] bytes = new byte[inputStream1.available()];

            inputStream1.read(bytes);

            outputStream.write(bytes);
        }

        if (inputStream2.available() > 0) {
            byte[] bytes = new byte[inputStream2.available()];

            inputStream2.read(bytes);

            outputStream.write(bytes);
        }

        outputStream.close();
        inputStream1.close();
        inputStream2.close();
        reader.close();
    }
}
