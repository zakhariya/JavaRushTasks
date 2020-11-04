package com.javarush.task;

public abstract class TestAbstract implements TestInterface {

    public TestAbstract() {

    }

    abstract void someMethod();

    void someAnotherMethod() {
        System.out.println("Print from abstract class.");
    }
}
