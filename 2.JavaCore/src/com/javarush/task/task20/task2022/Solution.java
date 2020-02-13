package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
//    private static final long serialVersionUID = 1L;

    private String fileName;
    private transient FileOutputStream stream;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) {
        try {
            String fileName = "e:\\for tests\\to_write.txt";
            String fileSer = "e:\\for tests\\some_class.dat";
            Solution solution = new Solution(fileName);
            solution.writeObject("String for test");
            solution.close();


            FileOutputStream fileOutputStream = new FileOutputStream(fileSer);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

            outputStream.writeObject(solution);

            fileOutputStream.close();
            outputStream.flush();
            outputStream.close();


            FileInputStream fileInputStream = new FileInputStream(fileSer);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

            Solution newSolution = (Solution) inputStream.readObject();

            newSolution.writeObject("Another string");
            newSolution.close();

            fileInputStream.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}