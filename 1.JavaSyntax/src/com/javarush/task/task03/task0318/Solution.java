package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int years = scanner.nextInt();
        scanner.nextLine(); // остаток - \n

        System.out.println(scanner.nextLine() + " захватит мир через " + years + " лет. Му-ха-ха!");
    }
}
