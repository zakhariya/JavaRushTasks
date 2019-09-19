package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
    }

    public static class Thread1 extends Thread {

        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class Thread2 extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class Thread3 extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {

        @Override
        public void run() {
            while (!this.isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }
    public static class Thread5 extends Thread {

        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        @Override
        public void run() {
            int count = 0;
            String s = "";

            try {
                while (!(s = reader.readLine()).equals("N")) {
                    count += Integer.parseInt(s);
                }

                System.out.println(count);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
            }
        }
    }
}