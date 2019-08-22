package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {

        return new Scanner(System.in).nextLine();
    }

    public static int readInt() throws Exception {

        return  new Scanner(System.in).nextInt();
    }

    public static double readDouble() throws Exception {

        return  new Scanner(System.in).nextDouble();
    }

    public static boolean readBoolean() throws Exception {

        return  new Scanner(System.in).nextBoolean();
    }

    public static void main(String[] args) {

    }
}
