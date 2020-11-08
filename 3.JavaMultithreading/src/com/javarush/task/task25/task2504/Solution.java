package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread thread :  threads) {
            Thread.State state = thread.getState();

            switch (state) {
                case NEW : {
                    thread.start();
                    break;
                }
                case BLOCKED: {
                    thread.interrupt();
                    break;
                }
                case WAITING: {
                    thread.interrupt();
                    break;
                }
                case TIMED_WAITING: {
                    thread.interrupt();
                    break;
                }
                case RUNNABLE: {
                    thread.isInterrupted();
                    break;
                }
                case TERMINATED: {
                    System.out.println(thread.getPriority());
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {

                }
            }
        };

        thread0.setName(thread0.getName() +" terminated");
        thread1.setName(thread1.getName() + " interrupted");
        thread2.setName(thread2.getName() + " waiting");

        thread0.start();
        thread1.start();
        Thread.sleep(500);
        thread1.interrupt();
        thread2.start();
        thread2.join(200);

        Thread.sleep(100);

        thread2.interrupt();


        Thread[] threads = {
                thread0,
                thread1,
                thread2,
                new Thread()
        };

        Solution.processThreads(threads);
    }
}
