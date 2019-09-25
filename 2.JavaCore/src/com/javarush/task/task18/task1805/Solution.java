package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName);

        List<Integer> bytes = new ArrayList<>();

        while (inputStream.available() > 0) {
            int b = inputStream.read();

            if (!bytes.contains(b)) {
                int size = bytes.size();

                if (size == 0) {
                    bytes.add(b);

                    continue;
                }

                for (int i = 0; i < size; i++) {
                    int v = bytes.get(i);

                    if (b < v) {
                        bytes.add(i, b);
                        break;
                    } else if (i == size - 1) {
                        bytes.add(b);
                        break;
                    }
                }
            }
        }

        for (int n : bytes) {
            System.out.printf("%d ", n);
        }

        reader.close();
        inputStream.close();
    }
}
