package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(20.0, "Some string");
        labels.put(20.5, "Some string");
        labels.put(10.0, "Some string");
        labels.put(25.0, "Some string");
        labels.put(21.0, "Some string");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
