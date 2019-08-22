package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String s = identColorOfСветофор((int) scanner.nextDouble());
/*

        if(scanner.hasNextInt())
            s = identColorOfСветофор(scanner.nextInt());
        else
            s = "Правила ужесточились....";
*/


        System.out.print(s);
        scanner.close();
    }

    private static String identColorOfСветофор(int time){
        String color = "";

        while(time >= 5){
            time -= 5;
        }

        if(time <= 2){
            color = "зелёный";
        }else if(time < 4){
            color = "жёлтый";
        }else{
            color = "красный";
        }

        return color;
    }
}