package com.javarush.task;

public class Solution {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("Bu");
            }
        };

        thread.start();
    }

}
