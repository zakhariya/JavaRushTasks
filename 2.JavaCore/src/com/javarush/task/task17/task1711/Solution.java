package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-i" : synchronized (allPeople) {
                info(Arrays.copyOfRange(args, 1, args.length));
            };
            break;
            case "-c" : synchronized (allPeople) {
                create(Arrays.copyOfRange(args, 1, args.length));
            }
            break;
            case "-u" : synchronized (allPeople) {
                update(Arrays.copyOfRange(args, 1, args.length));
            }
            break;
            case "-d" : synchronized (allPeople) {
                delete(Arrays.copyOfRange(args, 1, args.length));
            }
        }
    }

    private static void info(String[] args) {
        dateFormat.applyPattern("dd-MMM-yyyy");

        for (int i = 0; i < args.length; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i]));

            System.out.printf("%s %s %s\n",
                    person.getName(),
                    person.getSex().equals(Sex.FEMALE) ? "ж" : "м",
                    dateFormat.format(person.getBirthDate()));
        }
    }

    private static void create(String[] args) throws ParseException {
        for (int i = 0; i < args.length; i += 3) {
            String name = args[i];
            Date bd = dateFormat.parse(args[i + 2]);

            Person person = args[i + 1].equals("м") ?
                    Person.createMale(name, bd) : Person.createFemale(name, bd);

            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
    }

    private static void update(String[] args) throws ParseException {
        for (int i = 0; i < args.length; i += 4) {
            Person person = allPeople.get(Integer.parseInt(args[i]));

            person.setName(args[i + 1]);
            person.setSex(args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE);
            person.setBirthDate(dateFormat.parse(args[i + 3]));
        }
    }

    private static void delete(String[] args) {
        for (int i = 0; i < args.length; i++) {
            int id = Integer.parseInt(args[i]);

            Person person = allPeople.get(id);

            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);

            allPeople.set(id, person);
        }
    }
}
