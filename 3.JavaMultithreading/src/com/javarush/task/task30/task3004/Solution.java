package com.javarush.task.task30.task3004;

import java.util.concurrent.ForkJoinPool;

/* 
Fork/Join
*/

public class Solution {
    private static int coresNumber = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result1 = solution.binaryRepresentationMethod(6);
        System.out.println(result1);

        System.out.println();
        ForkJoinPool forkJoinPool = new ForkJoinPool(coresNumber);
        String result2 = forkJoinPool.invoke(new BinaryRepresentationTask(6));
        System.out.println(result2);
    }

    private String binaryRepresentationMethod(int x) {
        int a = x % 2;
        int b = x / 2;

        String result = String.valueOf(a);

        if (b > 0) {
            return binaryRepresentationMethod(b) + result;
        }

        return result;
    }

}
