package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer maximum = null;
        int count = 0;
        int current = 0;

        while(count == 0)
            count = Integer.parseInt(reader.readLine());

        for(int i=0; i<count; i++){
            current = Integer.parseInt(reader.readLine());

            if(maximum == null)
                maximum = current;
            else if(current > maximum)
                maximum = current;
        }

        System.out.println(maximum);
    }
}
