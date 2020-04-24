package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(args[0]), Charset.forName("Windows-1251")));

        String win1251 = "";

        while (reader.ready()) {
            win1251 += reader.readLine();

            if (reader.ready()) {
                win1251 += System.lineSeparator();
            }
        }

        reader.close();

        String utf8 = new String(win1251.getBytes(), Charset.forName("UTF-8"));

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(args[1]), Charset.forName("UTF-8")));

        writer.write(utf8);

        writer.close();
    }

}
