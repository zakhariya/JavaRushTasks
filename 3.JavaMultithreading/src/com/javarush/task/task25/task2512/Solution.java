package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if(e == null) return;
        t.interrupt();
        uncaughtException(t, e.getCause());

        System.out.println(e);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Thread thread = new Thread() {
            @Override
            public void run() {
                throw new Error("ABC", new InternalError("DEF", new AbstractMethodError("GHI")));
            }
        };

        thread.setUncaughtExceptionHandler(solution);
        thread.start();
    }
}
