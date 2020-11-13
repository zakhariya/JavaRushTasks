package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        Integer[] integers =
//                {18, 5,  8, 122};
////                {13, 8, 15, 18, 11};
//        solution.sort(integers);
//
//        for (int i : integers) {
//            System.out.println(i);
//        }
    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);

        int length = array.length;

        double median = length % 2 == 1 ? array[length / 2] : (array[length / 2 - 1] + array[length / 2]) / 2.0;

        Arrays.sort(array, Comparator.comparingInt(o -> Math.abs((int) median - o)));
        
        return array;
    }
}
