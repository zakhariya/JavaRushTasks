package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> fileNames = new ArrayList<>();

        String fileName = "";

        while (!(fileName = reader.readLine()).equals("end")) {
            fileNames.add(fileName);
        }

        reader.close();

        Collections.sort(fileNames);

        String name = fileNames.get(0);
        name = name.substring(0, name.lastIndexOf("."));

        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(name, true));

        for (String f : fileNames) {
            BufferedInputStream is = new BufferedInputStream(new FileInputStream(f));

            byte[] bytes = new byte[is.available()];

            is.read(bytes);

            os.write(bytes);

            is.close();
        }

        os.close();
    }
}