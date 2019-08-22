package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {

    private int top, left, width, height;

    public Rectangle(int width) {
        this.width = this.height = width;

        top = left = 0;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;

        top = left = 0;
    }

    public Rectangle(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = this.height = width;
    }

    public Rectangle(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public int getTop() {
        return top;
    }

    public int getLeft() {
        return left;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }



    public static void main(String[] args) {

    }
}
