package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        Map<String, Double> map = new HashMap<>();

        String line = "";

        Pattern namePattern = Pattern.compile("[а-яА-я\\p{Alpha}]*\\s");
        Pattern salaryPattern = Pattern.compile("[-]*[0-9]*[.,]?[0-9]+$");

        while ((line = bufferedReader.readLine()) != null) {
            Matcher nameMatcher = namePattern.matcher(line);
            Matcher salaryMatcher = salaryPattern.matcher(line);

            String name = "";
            double salary = 0.0;

            while (nameMatcher.find()) {
                name = nameMatcher.group().replace(" ", "");
            }

            while (salaryMatcher.find()) {
                salary = Double.parseDouble(salaryMatcher.group());
            }

            if (map.containsKey(name)) {
                salary += map.get(name);

            }

            map.put(name, salary);
        }

        bufferedReader.close();

        List<String> names = new ArrayList<>();


        for (Map.Entry<String, Double> pair : map.entrySet()) {
            names.add(pair.getKey());
        }

        Collections.sort(names);

        for (String name : names) {
            System.out.println(name + " " + map.get(name));
        }
    }
}
