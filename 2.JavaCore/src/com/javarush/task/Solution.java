package com.javarush.task;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String day = reader.readLine();
        int s = Integer.parseInt(day);//напишите тут ваш код
        if (s < 1 || s > 7) {
            System.out.println("такого дня недели не существует");
        } else if (s == 1) {
            System.out.println("понедльник");
        } else if (s == 2) {
            System.out.println("вторник");
        } else if (s == 3) {
            System.out.println("среда");
        } else if (s == 4) {
            System.out.println("четверг");
        } else if (s == 5) {
            System.out.println("пятница");
        } else if (s == 6) {
            System.out.println("суббота");
        }
        if (s==7)
        {
            System.out.println("воскресенье");
        }
    }
}