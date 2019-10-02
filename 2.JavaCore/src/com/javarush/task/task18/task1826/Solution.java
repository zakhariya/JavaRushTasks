package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream is = new FileInputStream(args[1]);
        FileOutputStream os = new FileOutputStream(args[2]);

        byte[] bytes = new byte[is.available()];

        is.read(bytes);

        if (args[0].equals("-e")) {
            for (int i = 0; i < bytes.length; i++) {
                String s = String.valueOf(bytes[i] + 1);
                bytes[i] = Byte.valueOf(s);
            }
            os.write(bytes);
        } else if (args[0].equals("-d")) {
            for (int i = 0; i < bytes.length; i++) {
                String s = String.valueOf(bytes[i] - 1);
                bytes[i] = Byte.valueOf(s);
            }
            os.write(bytes);
        }

        is.close();
        os.close();
    }
}
