package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/

public class Solution extends Thread {

    public Solution() {
        setUncaughtExceptionHandler( (t, e) -> {
            String message = e instanceof Error ? "Нельзя дальше работать" :
                    (e instanceof Exception ? "Надо обработать" : "Поживем - увидим");

            System.out.println(message);
        });
    }

    @Override
    public void run() {
        getUncaughtExceptionHandler().uncaughtException(this, new Error());
        getUncaughtExceptionHandler().uncaughtException(this, new Exception());
        getUncaughtExceptionHandler().uncaughtException(this, new Throwable());
    }

    public static void main(String[] args) {
        new Solution().start();
    }
}
