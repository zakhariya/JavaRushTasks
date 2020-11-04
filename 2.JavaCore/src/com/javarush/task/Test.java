package com.javarush.task;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Test extends TestAbstract { // as implements TestInterface
    //TODO: remove
    public static final String FIRST_FILE = "e:\\for tests\\to_read.txt";
    public static final String SECOND_FILE = "e:\\for tests\\to_write.txt";
    public static final File file = new File("e:\\for tests\\some_class.dat");

    // from TestInterface
    @Override
    void someMethod() {

    }

    @Override
    public void doSomeThing() {
        super.someAnotherMethod();
        System.out.println("Print from subclass");
    }

    @Override
    public int compareTo(TestInterface o) {
        return 0;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

//    public abstract void abstr();
}
