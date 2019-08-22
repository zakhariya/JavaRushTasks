package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 10; i++)
            list.add(Integer.parseInt(reader.readLine()));

        int maxSequence = 0;
        int sequence = 0;
        int listSize = list.size();

        for (int i = 0; i < listSize; i++, sequence++) {
            if (i == 0)
                continue;

            int number = list.get(i);

            if (number != list.get(i - 1)){
                if (sequence > maxSequence)
                    maxSequence = sequence;

                sequence = 0;
            }else if (i + 1 == listSize){
                if (++sequence > maxSequence)
                    maxSequence = sequence;
            }
        }

        System.out.println(maxSequence);
    }

    /*private static void incrementSequence(HashMap map, int key, int value){
        if(!map.keySet().contains(key)){
            map.put(key, 1);
        }else{
            int lastValue = (Integer) map.get(key);

            if (lastValue < value){
                map.remove(key);
                map.put(key, value);
            }
        }
    }*/
}