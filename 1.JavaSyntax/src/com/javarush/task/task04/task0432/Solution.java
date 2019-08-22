package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        scanner.nextLine();

        String[] s = new String[i];

        for (int j=0; j<s.length; j++)
            s[j] = scanner.nextLine();

        while (i-- > 0)
            System.out.println(s[i]);
    }
}
