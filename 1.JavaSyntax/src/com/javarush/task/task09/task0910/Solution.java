package com.javarush.task.task09.task0910;

import java.util.ArrayList;

/* 
Исключение при работе с коллекциями List
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        try {
            String s = list.get(18);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex.getClass());
        }

        //напишите тут ваш код
    }
}