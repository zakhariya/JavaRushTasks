package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String fileFirst = consoleReader.readLine();
        String fileSecond = consoleReader.readLine();

        consoleReader.close();

        FileReader firstFileReader = new FileReader(fileFirst);
        FileReader secondFileReader = new FileReader(fileSecond);

        List<String> firstLines = getArray(firstFileReader);
        List<String> secondLines = getArray(secondFileReader);

        firstFileReader.close();
        secondFileReader.close();

        fillList(firstLines, secondLines);
    }

    private static void fillList(List<String> firstLines, List<String> secondLines) {

        int l1 = firstLines.size();
        int l2 = secondLines.size();

        int j = 0;

        for (int i = 0; i < l1; i++) {
            String s = firstLines.get(i);

            if (j < l2 && s.equals(secondLines.get(j))) {
                lines.add(new LineItem(Type.SAME, s));
                j++;
            } else if (j + 1 < l2 && s.equals(secondLines.get(j + 1))) {
                lines.add(new LineItem(Type.ADDED, secondLines.get(j)));
                lines.add(new LineItem(Type.SAME, secondLines.get(j + 1)));
                j += 2;
            } else {
                lines.add(new LineItem(Type.REMOVED, s));
            }
        }

        if (j < l2) {
            lines.add(new LineItem(Type.ADDED, secondLines.get(j)));
        }
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
