package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'a', 'r', 'o', 'v'},
                {'o', 'h', 'e', 'm', 'o', 'h'},
                {'p', 'o', 'e', 'e', 'e', 'j'}
        };

        List<Word> words = detectAllWords(crossword, "home", "same", "daro", "kereo", "leo", "luf", "nar");

        for (Word word : words) {
            System.out.println(word.toString());
        }
        /*
            Ожидаемый результат
            home - (5, 3) - (2, 0)
            same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordList = new ArrayList<>();

        for (String word : words) {
            int fl = word.charAt(0);

            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (fl == crossword[i][j]) {
                        wordList.addAll(detectWord(new int[]{i, j}, crossword, word));
                    }
                }
            }
        }

        return wordList;
    }

    private static List<Word> detectWord(int[] beginCoords, int[][] crossword, String text) {
        List<Word> words = new ArrayList<>(8);

        int i = beginCoords[0];
        int j = beginCoords[1];

        int[] endCoords = null;

        if (searchEast(i, j, crossword, text)) {
            endCoords = new int[] {i, j + text.length() - 1};

            words.add(createWord(text, beginCoords, endCoords));
        }

        if (searchWest(i, j, crossword, text)) {
            endCoords = new int[] {i, j - text.length() + 1};

            words.add(createWord(text, beginCoords, endCoords));
        }

        if (searchNorth(i, j, crossword, text)) {
            endCoords = new int[] {i - text.length() + 1, j};

            words.add(createWord(text, beginCoords, endCoords));
        }

        if (searchSouth(i, j, crossword, text)) {
            endCoords = new int[] {i + text.length() - 1, j};

            words.add(createWord(text, beginCoords, endCoords));
        }

        if (searchNorthEast(i, j, crossword, text)) {
            endCoords = new int[] {i - text.length() + 1, j + text.length() - 1};

            words.add(createWord(text, beginCoords, endCoords));
        }

        if (searchNorthWest(i, j, crossword, text)) {
            endCoords = new int[] {i - text.length() + 1, j - text.length() + 1};

            words.add(createWord(text, beginCoords, endCoords));
        }

        if (searchSouthEast(i, j, crossword, text)) {
            endCoords = new int[] {i + text.length() - 1, j + text.length() - 1};

            words.add(createWord(text, beginCoords, endCoords));
        }

        if (searchSouthWest(i, j, crossword, text)) {
            endCoords = new int[] {i + text.length() - 1, j - text.length() + 1};

            words.add(createWord(text, beginCoords, endCoords));
        }

        return words;
    }

    private static boolean searchSouthWest(int i, int j, int[][] crossword, String text) {
        for (int k = 1; k < text.length(); k++) {
            try {
                if ((int) text.charAt(k) != crossword[i + k][j - k]) {
                    return false;
                }
            } catch (IndexOutOfBoundsException ex) {
                return false;
            }
        }

        return true;
    }

    private static boolean searchSouthEast(int i, int j, int[][] crossword, String text) {
        for (int k = 1; k < text.length(); k++) {
            try {
                if ((int) text.charAt(k) != crossword[i + k][j + k]) {
                    return false;
                }
            } catch (IndexOutOfBoundsException ex) {
                return false;
            }
        }

        return true;
    }

    private static boolean searchNorthWest(int i, int j, int[][] crossword, String text) {
        for (int k = 1; k < text.length(); k++) {
            try {
                if ((int) text.charAt(k) != crossword[i - k][j - k]) {
                    return false;
                }
            } catch (IndexOutOfBoundsException ex) {
                return false;
            }
        }

        return true;
    }

    private static boolean searchNorthEast(int i, int j, int[][] crossword, String text) {
        for (int k = 1; k < text.length(); k++) {
            try {
                if ((int) text.charAt(k) != crossword[i - k][j + k]) {
                    return false;
                }
            } catch (IndexOutOfBoundsException ex) {
                return false;
            }
        }

        return true;
    }

    private static boolean searchSouth(int i, int j, int[][] crossword, String text) {
        for (int k = 1; k < text.length(); k++) {
            try {
                if ((int) text.charAt(k) != crossword[i + k][j]) {
                    return false;
                }
            } catch (IndexOutOfBoundsException ex) {
                return false;
            }
        }

        return true;
    }

    private static boolean searchNorth(int i, int j, int[][] crossword, String text) {
        for (int k = 1; k < text.length(); k++) {
            try {
                if ((int) text.charAt(k) != crossword[i - k][j]) {
                    return false;
                }
            } catch (IndexOutOfBoundsException ex) {
                return false;
            }
        }


        return true;
    }

    private static boolean searchWest(int i, int j, int[][] crossword, String text) {
        for (int k = 1; k < text.length(); k++) {
            try {
                if ((int) text.charAt(k) != crossword[i][j - k]) {
                    return false;
                }
            } catch (IndexOutOfBoundsException ex) {
                return false;
            }
        }

        return true;
    }

    private static boolean searchEast(int i, int j, int[][] crossword, String text) {
        for (int k = 1; k < text.length(); k++) {
            try {
                if ((int) text.charAt(k) != crossword[i][j + k]) {
                    return false;
                }
            } catch (IndexOutOfBoundsException ex) {
                return false;
            }
        }

        return true;
    }

    private static Word createWord(String text, int[] beginCoords, int[] endCoords) {
        Word word = new Word(text);

        word.setStartPoint(beginCoords[1], beginCoords[0]);
        word.setEndPoint(endCoords[1], endCoords[0]);

        return word;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
