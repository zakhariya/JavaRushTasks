package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        InputStream inputStream = new FileInputStream(file1);
        OutputStream outputStream1 = new FileOutputStream(file2);
        OutputStream outputStream2 = new FileOutputStream(file3);

        int bytesCount = inputStream.available();

        if (bytesCount > 0) {
            byte[] bytes = new byte[bytesCount];

            int count = inputStream.read(bytes);
            int off = bytesCount % 2 > 0 ? count/2 + 1 : count/2;
            int len = count - off;

            outputStream1.write(bytes, 0, off);
            outputStream2.write(bytes, off, len);
        }

        outputStream2.close();
        outputStream1.close();
        inputStream.close();
        reader.close();
    }
}