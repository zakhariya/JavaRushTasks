package com.javarush.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ClassCasting {
    static class Pet
    {
        public void doPetActions() {
            System.out.println("Pet");
        }
    }
    static class Cat extends Pet
    {
        public void doCatActions() {
            System.out.println("Cat");
        }
    }
    static class Tiger extends Cat
    {
        public void doTigerActions() {
            System.out.println("Tiger");
        }
    }

    public static void main(String[] args)
    {

        Tiger tiger = new Tiger();
        Cat cat = new Tiger();
        Pet pet = new Tiger();
        Object objTiger = new Tiger();

        pet.doPetActions();
        ((Tiger) pet).doTigerActions();

        Pet petTiger = (Pet) objTiger;
        Cat catTiger = (Cat) objTiger;
        Tiger tiger1 = (Tiger) petTiger;
        Tiger tiger2 = (Tiger) catTiger;

        tiger1.doTigerActions();
        tiger2.doTigerActions();

        Pet petReal = new Pet();

        System.out.println(petTiger instanceof Tiger); // true
        System.out.println(petReal instanceof Tiger);  // false

//        Tiger tiger3 = (Tiger) new Pet();// ClassCastException

//        tiger3.doCatActions();

        if (objTiger instanceof Cat) {
            Cat cat3 = (Cat) objTiger;
            cat3.doCatActions();
        }

        // upcasting
        Cat catTiger1 = new Tiger();
        Pet petTiger1 = catTiger1;
        Object obj = catTiger1;
    }
}