package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        InputStream inputStream = new FileInputStream(reader.readLine());
        OutputStream outputStream = new FileOutputStream(reader.readLine());

        byte[] bytes = new byte[inputStream.available()];

        inputStream.read(bytes);

        String s = new String(bytes, "windows-1251");

        System.out.println(s);

//        System.out.println(new DecimalFormat("#0.00").format(result));

    }
}
