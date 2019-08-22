package com.javarush.task.task03.task0316;

/* 
Экранирование символов
*/

public class Solution {
    public static void main(String[] args) {
        String first = "It's Windows path: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"",
        second = "It's Java string: \\\"C:\\\\Program Files\\\\Java\\\\jdk1.7.0\\\\bin\\\"";

        System.out.print(first + "\n" + second);
    }
}
