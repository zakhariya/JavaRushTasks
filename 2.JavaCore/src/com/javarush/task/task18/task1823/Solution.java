package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = "";

        while (!(fileName = reader.readLine()).equals("exit")) {
            ReadThread thread = new ReadThread(fileName);

            thread.start();
        }

        reader.close();
    }


    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            BufferedInputStream stream = null;
            try {
                try {
                    stream = new BufferedInputStream(new FileInputStream(fileName));
                    Map<Integer, Integer> map = new HashMap<>();

                    while (stream.available() > 0) {
                        int b = stream.read();

                        if (map.containsKey(b)) {
                            int count = map.get(b);
                            map.put(b, ++count);
                        } else {
                            map.put(b, 1);
                        }
                    }

                    resultMap.put(fileName, getFrequent(map));
                } finally {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private int getFrequent(Map<Integer, Integer> map) {
            int max = 0;
            int maxCount = 0;

            for (Map.Entry<Integer, Integer> set : map.entrySet()) {
                int b = set.getKey();
                int count = set.getValue();

                if (count >= maxCount) {
                    max = b;
                    maxCount = count;
                }
            }

            return max;
        }
    }
}
