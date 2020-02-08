package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {

    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeUTF(firstName);
            out.writeUTF(lastName);
            out.writeInt(age);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = in.readUTF();
            lastName = in.readUTF();
            age = in.readInt();
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            children = (List<Person>)in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("e:\\for tests\\person.dat");

        Person father = new Person("Michael", "Smith", 65);
        Person man = new Person("John", "Smith", 39);
        Person daughter = new Person("Elly", "Smith", 12);

        List<Person> children1 = new ArrayList<>();
        children1.add(man);

        List<Person> children2 = new ArrayList<>();
        children2.add(daughter);

        father.setChildren(children1);

        man.setFather(father);
        man.setChildren(children2);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));

        outputStream.writeObject(man);
        outputStream.writeObject(daughter);
        outputStream.writeObject(father);
        outputStream.flush();
        outputStream.close();

        InputStream fis = new FileInputStream(file);
        ObjectInputStream inputStream = new ObjectInputStream(fis);

        while(fis.available() > 0) {
            Person person = (Person) inputStream.readObject();

            System.out.println(person.firstName);
        }

        inputStream.close();
    }
}
