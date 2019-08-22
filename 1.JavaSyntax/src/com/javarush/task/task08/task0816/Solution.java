package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);

        HashMap<String, Date> map = new HashMap<String, Date>();

        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put("Stallone2", df.parse("JULY 12 1973"));
        map.put("Stallone3", df.parse("AUGUST 21 1989"));
        map.put("Stallone4", df.parse("SEPTEMBER 1 1939"));
        map.put("Stallone5", df.parse("OCTOBER 31 1995"));
        map.put("Stallone6", df.parse("NOVEMBER 7 1991"));
        map.put("R2D2", df.parse("DECEMBER 10 1980"));
        map.put("Stallone 7", df.parse("JANUARY 1 1970"));
        map.put("Stall", df.parse("FEBRUARY 1 1980"));
        map.put("Lone", df.parse("MARCH 1 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Date june = new Date();
        june.setMonth(5);
        Date july = new Date();
        july.setMonth(6);
        Date august = new Date();
        august.setMonth(7);

        ArrayList<String> lastNames = new ArrayList<>();

        for (Map.Entry<String, Date> pair : map.entrySet()){
            Date birthDay = pair.getValue();

            if (birthDay.getMonth() == june.getMonth() ||
                    birthDay.getMonth() == july.getMonth() ||
                    birthDay.getMonth() == august.getMonth())
                lastNames.add(pair.getKey());
        }

        for (String lastName : lastNames)
            map.remove(lastName);

        //TODO: remove
//        for (String lastName : map.keySet())
//            System.out.println(lastName);
    }

    public static void main(String[] args) {
        try {
            removeAllSummerPeople(createMap());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
