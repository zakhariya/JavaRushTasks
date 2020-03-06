package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {

    int node;
    List<Solution> edges = new LinkedList<>();
    Obj obj;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution();
        solution.node = 1;

        Obj obj = new Obj();
        solution.obj = obj;
        solution.obj.text = "sSome text";
        solution.obj.solution = solution;

        for (int i = 0; i < 10; i++) {
                Solution edge1 = new Solution();
                edge1.node = 2;
                edge1.obj = obj;
                edge1.obj.solution = edge1;

                solution.edges.add(edge1);

            for (int j = 0; j < 5; j++) {
                Solution edge2 = new Solution();
                edge2.node = 3;
                edge2.obj = obj;

                edge1.edges.add(edge2);
            }
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);

        outputStream.writeObject(solution);
        outputStream.flush();
        outputStream.close();


        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);

        Solution newSolution = (Solution) inputStream.readObject();

        System.out.println(newSolution.toString());
    }

    @Override
    public String toString() {
        return "Solution{" +
                "node=" + node +
                ", obj=" + obj +
                ", edges=" + edges +
                '}';
    }
}
class Obj extends Solution implements Serializable{
    String text = "Some text";
    Solution solution;

    @Override
    public String toString() {
        return "Obj{" +
                "node=" + node +
                ", edges=" + edges +
                ", obj=" + obj +
                ", text='" + text + '\'' +
                ", solution=" + System.identityHashCode(solution) +
                '}';
    }
}
