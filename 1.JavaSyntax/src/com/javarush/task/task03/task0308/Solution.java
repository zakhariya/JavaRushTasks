package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getResult(10));
    }
    private static int getResult(int count){
        int result = count;

        while(--count > 0)
            result *= count;

        return result;
    }
}
