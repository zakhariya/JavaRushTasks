package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String file = consoleReader.readLine();

        BufferedReader fileReader = new BufferedReader(new FileReader(file));

        String text = "";
        String tag = args[0];

        while (fileReader.ready()) {
            text += fileReader.readLine();
        }

        List<String> tagList = getTagList(tag, text);

        for (String t : tagList) {
            System.out.println(t);
        }

        consoleReader.close();
        fileReader.close();
    }

    private static List<String> getTagList(String tag, String text) {
        List<String> list = new ArrayList<>();

        Pattern patternOpenTag = Pattern.compile("<" + tag + ".*?>", Pattern.MULTILINE);
        Matcher matcherOpenTag = patternOpenTag.matcher(text);

        while (matcherOpenTag.find()) {
            int idx = matcherOpenTag.start();

            list.add(getTag(text.substring(idx), tag));
        }

        return list;
    }

    private static String getTag(String text, String tag) {
        Pattern pattern =
                Pattern.compile("(<" + tag + ".*?>|<\\/" + tag + ".*?>)", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);

        int opened = 0;

        while (matcher.find()) {
            if (matcher.group().matches("<" + tag + ".*?>")) {
                opened++;
            } else {
                opened--;
            }

            if (opened == 0) {
                return text.substring(0, matcher.end());
            }
        }

        return "";
    }
}
