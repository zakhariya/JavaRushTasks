package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        InputStream inputStream = new FileInputStream(reader.readLine());

        while (inputStream.available() >= 1000) {
            inputStream = new FileInputStream(reader.readLine());
        }

        inputStream.close();
        reader.close();

        throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}