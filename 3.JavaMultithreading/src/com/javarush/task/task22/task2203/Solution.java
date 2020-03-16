package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();

        int idxBegin = string.indexOf('\t');
        int idxLast = string.indexOf('\t', idxBegin + 1);

        if (idxBegin < 0 || idxBegin >= idxLast) {
            throw new TooShortStringException();
        }

        return string.substring(idxBegin + 1, idxLast);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
