package com.javarush.task.task25.task2514;

/* 
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/

public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread(new YieldRunnable(1));
        thread0.start();
//        thread0.join(100);
        new Thread(new YieldRunnable(2)).start();
        new Thread(new YieldRunnable(3)).start();
        new Thread(new YieldRunnable(4)).start();
    }
}
