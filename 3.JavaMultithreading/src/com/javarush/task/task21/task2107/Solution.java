package com.javarush.task.task21.task2107;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    protected Map<String, User> users = new LinkedHashMap();

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));

        Solution clone = null;

        try {
            clone = (Solution) solution.clone();

            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution solution = new Solution();
        Map<String, User> users = new LinkedHashMap<>();

        for (Map.Entry<String, User> pair : this.users.entrySet()) {
            users.put(pair.getKey(), pair.getValue());
        }

        solution.users = users;

        return solution;
    }

    public static class User implements Cloneable {
        int age;

        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
