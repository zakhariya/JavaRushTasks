package com.javarush.task.task03.task0306;

/* 
Головоломка со скобками
*/

public class Solution {
//    public static void main(String[] args) {
//
//        System.out.println(1 + 2 * (3 + 4 * (5 + 6 * 7) + 8 * 9) + 10);
//    }

    public static void main(String[] args){
        final int RESULT = 537;
        int numbersCount = 3;
        int[] numbers = new int[numbersCount];

        int i=0;
        while(i < numbersCount)
            numbers[i] = ++i;

        // 1 + 2 * (3 + 4 * (5 + 6 * 7) + 8 * 9) + 10
        //1 + 2 * 3 + 4 * 5
        //1 + 2 * (3 + 4) * 5
        //(1 + 2) * 3 + 4 * 5
        //(1 + 2) * (3 + 4) * 5
        //1 + 2 * (3 + 4 * 5)
        //1 + 2 * ((3 + 4) * 5)
        //(1 + 2) * (3 + 4 * 5)
        //(1 + 2) * ((3 + 4) * 5)
        //(1 + 2 * 3) + 4 * 5
        //((1 + 2 * 3) + 4) * 5
        //((1 + 2) * (3 + 4)) * 5
        System.out.println(getIt(numbers, RESULT));
    }

    private static String getIt(int [] nums, int res){
        int operationsCount = nums.length - 1;
        String s = "";

        int i1;
        int i2;

        for(int i=0; i < operationsCount; i++){

            if(i+1 <= nums.length){
                i1 = nums[i];
                i2 = nums[i+1];

                if(i % 2 > 0){
                    s += i1 + " * " + i2;
                }else{
                    s += i1 + " + " + i2;
                }
            }else{
                return s;
            }
        }

        return s;
    }

    private class Expression {
        private int amount;
        private String expression;
        private int [] numbers;

    }
}
