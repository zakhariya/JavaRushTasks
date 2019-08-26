package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream inputStream = new FileInputStream(scanner.nextLine());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<Integer> evens = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null ) {
            if (line.equals("")) {
                continue;
            }

            int n = Integer.parseInt(line);

            if (n % 2 == 0) {
                evens.add(n);
            }
        }

        evens.sort(Integer::compareTo);

        for (int n : evens) {
            System.out.println(n);
        }

        inputStream.close();
        reader.close();
        scanner.close();
    }
}
