package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws  CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new C(super.getI(), super.getJ(), super.getName());
        }
    }

    public static void main(String[] args) {
        A a = new A(5, 9);
        B b = new B(4, 1, "Gdfsf");
        C c = new C(6, 8, "Aaaa");

        try {
            System.out.println(a + " " + a.clone());
            System.out.println(c + " " + c.clone());
            System.out.println(b + " " + b.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
