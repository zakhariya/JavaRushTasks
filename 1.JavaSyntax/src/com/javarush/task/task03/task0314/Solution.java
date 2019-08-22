package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        for (int i=1; i<=10; i++){
            String s = "";

            for (int j=1; j<=10; j++){
                s += i * j;
                if(j < 10)
                    s += " ";
            }

            System.out.println(s);
        }
    }
}
