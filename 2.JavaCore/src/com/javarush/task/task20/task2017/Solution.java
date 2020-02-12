package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream) {

        try {
            A a = (A) objectStream.readObject();

            if (a instanceof A) {
                return a;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution();
        A a = solution. new A();
        B b = solution. new B();

        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteOutputStream);

//        outputStream.writeObject(a);
        outputStream.writeObject(b);

        byte[] bytes = byteOutputStream.toByteArray();

        byteOutputStream.close();
        outputStream.close();

        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream inputStream = new ObjectInputStream(byteInputStream);

        A a2 = solution.getOriginalObject(inputStream);

        byteInputStream.close();
        inputStream.close();

        System.out.println(a2);
    }
}
