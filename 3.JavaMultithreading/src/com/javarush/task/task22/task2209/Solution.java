package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = consoleReader.readLine();

        consoleReader.close();

        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));

        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);

        inputStream.close();

        StringBuilder result = getLine(new String(bytes).split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length < 1) {
            return new StringBuilder();
        }

        List<Word> wordList = new LinkedList<>();

        for (String word : words) {
            wordList.add(new Word(word));
        }

        addOutputsToWords(wordList);

        List<String> list = getSortedList(wordList);

        return new StringBuilder(list.toString().replaceAll("\\[|\\]|,", ""));
    }

    private static void addOutputsToWords(List<Word> words) {
        List<Word> copy = new LinkedList<>(words);

        for (Word word : words) {
            for (Word output : copy) {
                if (word != output && isWordOutput(word, output)) {
                    word.addOutput(output);
                }
            }
        }
    }

    private static boolean isWordOutput(Word word, Word output) {
        String firstText = word.getText();
        String secondText = output.getText();

        return firstText.substring(firstText.length() - 1)
                .equalsIgnoreCase(secondText.substring(0, 1));
    }

    private static List<String> getSortedList(List<Word> words) {
        List<String> list = new LinkedList<>();

        for (Word word : words) {
            List<Word> wordLine = getOutputLine(word, new LinkedList<>(), words.size());

            if (wordLine.size() == words.size()) {
                for (Word w : wordLine) {
                    list.add(w.getText());
                }

                return list;
            }
        }

        return list;
    }

    private static List<Word> getOutputLine(Word word, List<Word> wordLine, int count) {
        wordLine.add(word);

        for (Word output : word.getOutputs()) {
            if (!wordLine.contains(output)) {
                getOutputLine(output, wordLine, count);

                if (wordLine.size() == count) {
                    return wordLine;
                }

                wordLine.remove(output);
            }
        }

        return wordLine;
    }
}

class Word {
    private String text;
    List<Word> outputs = new LinkedList<>();

    public Word(String text) {
        this.text = text;
    }

    public void addOutput(Word word) {
        if (!outputs.contains(word)) {
            outputs.add(word);
        }
    }

    public String getText() {
        return text;
    }

    public List<Word> getOutputs() {
        return outputs;
    }

    @Override
    public String toString() {
        return "Word{" +
                "text=" + text + '\'' +
                ", output count=" + outputs.size() +
                '}';
    }
}
