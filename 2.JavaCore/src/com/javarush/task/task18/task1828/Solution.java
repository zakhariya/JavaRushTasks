package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        if (args[0].equals("-u")) {
            String[] params = Arrays.copyOfRange(args, 1, 5);
            update(params, fileName);
        } else if (args[0].equals("-d")) {
            delete(args[1], fileName);
        }

        reader.close();
    }

    private static void update(String[] params, String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        List<String> lines = reader.lines().collect(Collectors.toList());

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (String line : lines) {
            String id = line.substring(0, 8).replaceAll(" ", "");
            System.out.println(Arrays.toString(id.getBytes())+ " " + Arrays.toString(params[0].getBytes()));
            if (id.equals(params[0])) {
                String newObj = addSpaces(params[0], 8) + addSpaces(params[1], 30)
                        + addSpaces(params[2], 8) + addSpaces(params[3], 4);

                line = newObj;
            }

            writer.write(line);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

    private static void delete(String idRemove, String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        List<String> lines = reader.lines().collect(Collectors.toList());

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String id = line.substring(0, 8);

            if (!id.replace(" ", "").equals(idRemove)) {
                writer.write(line);

                if (i + 1 < lines.size()) {
                    writer.newLine();
                }
            }
        }

        reader.close();
        writer.close();
    }

    private static String addSpaces(String s, int count) {
        while (s.length() < count) {
            s += " ";
        }

        return s;
    }
}

//d:\file_to_write_2.txt