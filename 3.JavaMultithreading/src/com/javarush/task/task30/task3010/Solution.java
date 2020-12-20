package com.javarush.task.task30.task3010;

import java.math.BigInteger;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        try {
            if (args.length < 1 || args[0].length() > 255) {
                return;
            }
            int radix = getMinimalRadix(args[0]);

            if (radix == 0) {
                System.out.println("incorrect");
            } else {
                System.out.println(radix);
            }
        } catch (Exception e) {
        }
    }

    private static int getMinimalRadix(String s) throws Exception {
        for (int i = 2; i <= 36; i++) {
            try {
                new BigInteger(s, i);

                return i;
            } catch (Exception e) {
            }
        }

        return 0;
    }
}
