package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
//        System.out.println(getPartOfString("Амиго и Диего лучшиедрузья!"));
//        System.out.println(getPartOfString(""));
        System.out.println(getPartOfString(null));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException(new NullPointerException());

        int idxFourthSpace = -1;
        int count = 0;

        for (int i = 0; i < 4; i++) {
            idxFourthSpace = string.indexOf(' ', idxFourthSpace + 1);

            if (idxFourthSpace >= 0) {
                count++;
            } else if (count < 4) {
                throw new TooShortStringException("Not enough spaces");
            }
        }

        int idxFifthSpace = string.indexOf(' ', idxFourthSpace + 1);

        int idxBegin = string.indexOf(' ') + 1;
        int idxLast = idxFifthSpace > -1 ? idxFifthSpace : string.length();

        try {
            return string.substring(idxBegin, idxLast);
        } catch (Exception e) {
            throw new TooShortStringException(e);
        }
    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException(String message) {
            super(message);
        }

        public TooShortStringException(Throwable e) {
            super(e);
        }
    }
}
