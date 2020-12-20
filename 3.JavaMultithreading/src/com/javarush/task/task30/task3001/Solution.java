package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/* 
Конвертер систем счислений
*/

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef

        number = new Number(NumberSystemType._16, "-3");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);

        number = new Number(NumberSystemType._2, "-1");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        String result = "";
        String n = number.getDigit();
        int ns = number.getNumberSystem().getNumberSystemIntValue();
        int ens = expectedNumberSystem.getNumberSystemIntValue();

        try {
            BigInteger a = new BigInteger(n, ns);
            System.out.println(a);
            BigInteger b = new BigInteger(a.toString());
            result = b.toString(ens);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(String.format("Низя так для %s в %dx системе", n, ns));
        }

        return new Number(expectedNumberSystem, result);
    }
}
