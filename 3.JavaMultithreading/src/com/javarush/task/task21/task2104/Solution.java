package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
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

        if (o == null || getClass() != o.getClass()) return false;

        if (!(o instanceof Solution)) return false;

        Solution n = (Solution) o;

        return first == (n.first) && last == (n.last);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 0;

        result += prime * (first == null ? 0 : first.hashCode());
        result += last == null ? 0 : last.hashCode();

        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();

        s.add(new Solution("Donald", "Duck"));
        s.add(new Solution(null, null));

        System.out.println(s.contains(new Solution("Donald", "Duck")));

        System.out.println(s.contains(new Solution(null, "Duck")));
    }
}
