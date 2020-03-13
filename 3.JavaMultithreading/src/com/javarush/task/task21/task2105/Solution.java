package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null) return false;

        if (!(o instanceof Solution))
            return false;

        Solution n = (Solution) o;

        if (first == n.first && last == n.last) return true;

        return (first != null && n.first.equals(first))
                && (last != null && n.last.equals(last));
    }

    @Override
    public int hashCode() {
        int prime = 31;

        return prime * (first == null ? 0 : first.hashCode())
                + (last == null ? 0 : last.hashCode());
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();

        s.add(new Solution("Mickey", "Mouse"));
        s.add(new Solution(null, "Mouse"));
        s.add(new Solution(null, null));

        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
        System.out.println(s.contains(new Solution(null, "Mouse")));
    }
}
