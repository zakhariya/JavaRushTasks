package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println(getCoordinateQuarter(scanner.nextInt(), scanner.nextInt()));
    }

    private static int getCoordinateQuarter(int x, int y){
        if(x > 0 && y > 0)
            return 1;
        else if(x < 0 && y > 0)
            return 2;
        else if(x < 0 && y < 0)
            return 3;

        return 4;
    }
}
