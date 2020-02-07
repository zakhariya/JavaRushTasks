package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        load(inputStream);

        reader.close();
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties props = new Properties();

        props.putAll(properties);
        props.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        Properties props = new Properties();

        props.load(inputStream);

        props.forEach(
                (k, v) -> properties.put((String) k, (String) v)
        );
    }

    public static void main(String[] args) throws Exception {

    }
}
