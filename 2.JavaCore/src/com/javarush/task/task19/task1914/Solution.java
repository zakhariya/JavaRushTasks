package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream out = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        testString.printSomething();

        String result = byteArrayOutputStream.toString();

        System.setOut(out);

        List<Integer> numbers = new ArrayList<>(2);

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(result);

        while (matcher.find()) {
//            System.out.println(matcher.group());
            numbers.add(Integer.parseInt(matcher.group()));
        }

        char sign = result.replaceAll("[^+|\\-|*]", "").charAt(0);

        int a = numbers.get(0);
        int b = numbers.get(1);

        System.out.println(result + calculate(a, b, sign));
    }

    private static int calculate(int a, int b, char sign) {
        int result = 0;

        if (sign == '+') {
            result = a + b;
        } else if (sign == '-') {
            result = a - b;
        } else {
            result = a * b;
        }

        return result;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

