package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> arrayList = new ArrayList<>();

        int minLength = 0;
        int maxLength = 0;


        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            int length = s.length();

            if(i == 0){
                minLength = length;
                maxLength = length;
            }else{
                if (length < minLength)
                    minLength = length;
                if (length > maxLength)
                    maxLength = length;
            }

            arrayList.add(s);
        }

        for (String s : arrayList){
            int length = s.length();

            if (length == minLength){
                System.out.println(s);

                break;
            }else if(length == maxLength){
                System.out.println(s);

                break;
            }
        }
    }
}
