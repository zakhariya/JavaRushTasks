package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution solution = new Solution();

        try {
            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new InputStreamReader(System.in));

                String name1 = reader.readLine();
                String name2 = reader.readLine();

                reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(name1), "Windows-1251"));

                while (reader.ready()) {
                    allLines.add(reader.readLine());
                }

                reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(name2), "Windows-1251"));

                while (reader.ready()) {
                    forRemoveLines.add(reader.readLine());
                }

                solution.joinData();

            } finally {
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(allLines);
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();

            throw new CorruptedDataException();
        }
    }
}