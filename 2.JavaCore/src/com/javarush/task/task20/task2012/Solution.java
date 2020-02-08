package com.javarush.task.task20.task2012;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
OutputToConsole
*/
public class Solution {
    public static String greeting = "Hello world";

    /**
     * OutputToConsole is an inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for displaying the [greeting] variable to the console.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int counter;

        public OutputToConsole() {
        }

        /**
         * Class constructor that sets the private counter field.
         */
        public OutputToConsole(int counter) {
            this.counter = counter;
        }

        /**
         * @param out A stream for externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(counter);
        }

        /**
         * @param in A stream for de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            counter = in.readInt();
        }

        /**
         * Prints greeting message to console counter times.
         */
        public void printMessage() {
            for (int i = 0; i < counter; i++) {
                System.out.println(greeting);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("e:\\for tests\\some_class.dat");

        OutputToConsole toConsoleOne = new OutputToConsole(1);
        OutputToConsole toConsoleTwo = new OutputToConsole(2);
        OutputToConsole toConsoleThree = new OutputToConsole(16);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));

        outputStream.writeObject(toConsoleOne);
        outputStream.writeObject(toConsoleTwo);
        outputStream.writeObject(toConsoleThree);

        outputStream.flush();
        outputStream.close();

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));

        OutputToConsole newToConsoleOne = (OutputToConsole) inputStream.readObject();
        OutputToConsole newToConsoleTwo = (OutputToConsole) inputStream.readObject();
        OutputToConsole newToConsoleThree = (OutputToConsole) inputStream.readObject();

        inputStream.close();

        newToConsoleOne.counter++;

        System.out.println(toConsoleOne.counter);
        System.out.println(toConsoleTwo.counter);
        System.out.println(toConsoleThree.counter);

        System.out.println();

        System.out.println(newToConsoleOne.counter);
        System.out.println(newToConsoleTwo.counter);
        System.out.println(newToConsoleThree.counter);
    }
}
