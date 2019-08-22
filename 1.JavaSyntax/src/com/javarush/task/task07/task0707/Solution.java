package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> array = new ArrayList<>();

        array.add("fdgfgd");
        array.add("dfgfgr");
        array.add("ghfrt");
        array.add("yhrther");
        array.add("nfgbfgh");

        System.out.println(array.size());

        for (String s : array)
            System.out.println(s);
    }
}
