package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {

        private void writeObject(ObjectOutputStream os) throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream is) throws NotSerializableException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution s = new Solution();
        SubSolution ss = new SubSolution();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);

        outputStream.writeObject(ss);
        outputStream.close();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);

        Solution ss2 = (Solution) inputStream.readObject();

        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        inputStream.close();

        System.out.println(ss2);
    }
}
