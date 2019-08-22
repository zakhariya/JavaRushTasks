package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("FEBRUARY 1 2019"));
    }

    public static boolean isDateOdd(String date) {
        Date yearBegin = new Date(date);
        yearBegin.setDate(1);
        yearBegin.setMonth(0);

        Date lastDate = new Date(date);
        lastDate.setHours(24);

        int days = (int) ((lastDate.getTime() - yearBegin.getTime())/(1000 * 60 * 60 * 24));

        System.out.println(days);

        return days % 2 > 0 ? true : false;
    }
}
