package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        Pattern namePattern = Pattern.compile("[а-яА-я\\p{Alpha}]*[-]*[а-яА-я\\p{Alpha}]*[^0-9]\\s");
        Pattern birthPattern = Pattern.compile("(\\d+(?:\\.\\d+)?)");

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String line = "";

        while ((line = bufferedReader.readLine()) != null) {
            Matcher nameMatcher = namePattern.matcher(line);
            List<String> names = new ArrayList<>();

            while (nameMatcher.find()) {
                names.add(nameMatcher.group().replace(" ", ""));
            }

            Matcher birthMatcher = birthPattern.matcher(line);
            List<String> dates = new ArrayList<>();

            while (birthMatcher.find()) {
                dates.add(birthMatcher.group());
            }

            String name = removeChars(names.toString());
            String dateString = removeChars(dates.toString()).replace(" ", "/");

            PEOPLE.add(new Person(name, dateFormat.parse(dateString)));
        }

        bufferedReader.close();
    }

    private static String removeChars(String s) {
        return s.replace(",", "")
                .replace("[", "")
                .replace("]", "");
    }
}
