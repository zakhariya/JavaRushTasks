package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = consoleReader.readLine();

        consoleReader.close();

        PrintStream out = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        FileOutputStream fileWriter = new FileOutputStream(fileName);

        System.setOut(printStream);

        testString.printSomething();

        String text = byteArrayOutputStream.toString();

        System.setOut(out);

        fileWriter.write(text.getBytes());
        System.out.println(text);

        fileWriter.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

