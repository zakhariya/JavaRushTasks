package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); // 0
        list.add("лоза"); // 1
        list.add("лира"); // 2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {

        ArrayList<String> tmp = new ArrayList<>();

        int size = list.size();

        for (int i = 0; i < size; i++) {
            String s = list.get(i);

            if(!s.contains("р")
                    || s.contains("р") && s.contains("л"))
                tmp.add(s);

            if (s.contains("л") && !s.contains("р"))
                tmp.add(s);

        }

        return tmp;
    }
}