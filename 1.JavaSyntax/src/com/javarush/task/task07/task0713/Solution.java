package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arrayList = new ArrayList();
        ArrayList<Integer> делятсяНаТри = new ArrayList<>();
        ArrayList<Integer> делятсяНаДва = new ArrayList<>();
        ArrayList<Integer> иОстальные = new ArrayList<>();

        for (int i = 0; i < 20; i++)
            arrayList.add(Integer.parseInt(reader.readLine()));

        for (int x : arrayList){
            if (x % 3 == 0 && x % 2 == 0){
                делятсяНаДва.add(x);
                делятсяНаТри.add(x);
            }else if (x % 3 == 0){
                делятсяНаТри.add(x);
            }else if (x % 2 == 0){
                делятсяНаДва.add(x);
            }else {
                иОстальные.add(x);
            }
        }

        printList(делятсяНаТри);
        printList(делятсяНаДва);
        printList(иОстальные);
    }

    public static void printList(List<Integer> list) {
        for (int x : list)
            System.out.println(x);
    }
}
