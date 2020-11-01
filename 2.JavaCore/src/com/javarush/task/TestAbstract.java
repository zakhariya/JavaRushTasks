package com.javarush.task;

public abstract class TestAbstract {

    public TestAbstract() {

    }

    abstract void someMethod();

    void someAnotherMethod() {
        System.out.println("Print from abstract class.");
    }
}
