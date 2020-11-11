package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private List<Human> children = new ArrayList<>();
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    protected Size size;
    private BloodGroup bloodGroup;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void removeChild(Human child) {
        children.remove(child);
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public String getPosition() {
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    @Override
    public void live() {
    }

    //TODO: remove
    public static void main(String[] args) {
        Worker human = new Worker("Viktor", 55);

        List<Human> children = java.util.Arrays.asList(new Student("Olya", 19, 1.0), new Human("Dima", 8), new Soldier("Sasha", 22));

        children.forEach(child -> human.addChild(child));

//        System.out.println((human.children == human.getChildren()) + " " + human.children.equals(human.getChildren()));
        System.out.println((children == human.getChildren()) + " " + children.equals(human.getChildren()));

        human.getChildren().forEach(child -> System.out.println(child + " " + child.name));

        List<Human> changedChildren = human.getChildren();
        changedChildren.get(0).age = 11;
        changedChildren.get(0).name = "Olha";

        human.getChildren().forEach(child -> System.out.println(child + " " + child.name));
    }

    public class Size {
        public int height;
        public int weight;


    }
}