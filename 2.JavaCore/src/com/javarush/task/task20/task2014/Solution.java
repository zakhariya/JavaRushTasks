package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        File file = new File("e:\\for tests\\some_class.dat");

        Solution savedObject = new Solution(4);
        Solution savedObject2 = new Solution(6);

        try {
            OutputStream fos = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(fos);

            outputStream.writeObject(savedObject);
            outputStream.writeObject(savedObject2);

            outputStream.flush();
            outputStream.close();

            InputStream fis = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(fis);

            Solution loadedObject = (Solution) inputStream.readObject();

            System.out.println(savedObject.string.equals(loadedObject.string));

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        this.string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), this.temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
