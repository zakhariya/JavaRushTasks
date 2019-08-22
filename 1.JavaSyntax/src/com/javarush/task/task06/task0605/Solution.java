package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.massIndex(weight, height);
    }

    public static class Body {
        public static void massIndex(double weight, double height) {
            double koef = weight/(height * height);
            String msg = "";

            if(koef < 18.5)
                msg = "Недовес: меньше чем 18.5";
            else if(koef >= 18.5 && koef <= 24.9)
                msg = "Нормальный: между 18.5 и 24.9";
            else if(koef < 30)
                msg = "Избыточный вес: между 25 и 29.9";
            else
                msg = "Ожирение: 30 или больше";

            System.out.println(msg);
        }
    }
}
