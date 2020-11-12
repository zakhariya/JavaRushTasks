package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Убежденному убеждать других не трудно
*/

public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int res = 0;
            for (Comparator<T> comparator : comparators) {
                res = comparator.compare(o1, o2);
                if (res != 0) {
                    return res;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {

        Comparator<Object> customizedComparator = new CustomizedComparator<Object>(new Comparator[5]);
        Collections.sort(new ArrayList<String>(5), customizedComparator);
    }
}
