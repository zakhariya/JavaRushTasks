package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String line = fileScanner.nextLine();

            String[] data = line.split(" ");

            return getPerson(data);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }

        private Person getPerson(String[] data) {
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String date = String.format("%s/%s/%s", data[3], data[4], data[5]);

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate = null;

            try {
                birthDate = dateFormat.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return new Person(firstName, middleName, lastName, birthDate);
        }
    }
}