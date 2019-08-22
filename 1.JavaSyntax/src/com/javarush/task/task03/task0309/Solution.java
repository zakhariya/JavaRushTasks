package com.javarush.task.task03.task0309;

/* 
Сумма 5 чисел
*/

public class Solution {
    public static void main(String[] args) {
        printAmmounts(5);
    }

    private static void printAmmounts(int count){
        int ammount = 0;

        for(int i=1; i <= count; i++){
            System.out.println(ammount += i);
        }
    }
}
