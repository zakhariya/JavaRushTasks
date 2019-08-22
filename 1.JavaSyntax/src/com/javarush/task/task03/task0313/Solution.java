package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();

        arr.add("Мама");
        arr.add("Мыла");
        arr.add("Раму");

        printIt(arr);
    }

    private static void printIt(ArrayList<String> arr){
        int size = arr.size();

        for(int i=0; i<size; i++){
            for(int j=0; j<size-1; j++){
                for (String s : arr)
                    System.out.print(s);
                System.out.print("\n");

                String tmp = arr.get(j);
                arr.set(j, arr.get(j+1));
                arr.set(j+1, tmp);
            }
        }
    }
}
