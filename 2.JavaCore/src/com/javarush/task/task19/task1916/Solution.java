package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    //TODO: remove
    private static final String FIRST_FILE = "e:\\for tests\\to_read.txt";
    private static final String SECOND_FILE = "e:\\for tests\\to_write.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String fileFirst = consoleReader.readLine();
        String fileSecond = consoleReader.readLine();

        consoleReader.close();

        FileReader firstFileReader = new FileReader(FIRST_FILE);
        FileReader secondFileReader = new FileReader(SECOND_FILE);

        List<String> firstLines = getArray(firstFileReader);
        List<String> secondLines = getArray(secondFileReader);

        firstFileReader.close();
        secondFileReader.close();

        fillList(firstLines, secondLines);

        System.out.println(lines);
    }

    private static void fillList(List<String> firstLines, List<String> secondLines) {
//        firstLines.contains()
    }

    private static List<String> getArray(FileReader fileReader) throws IOException {
        List<String> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(fileReader);

        String line = "";

        while ((line = br.readLine()) != null) {
            list.add(line);
        }

        return list;
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
