package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        if (args[0].equals("-i")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            dateFormat.applyPattern("dd-MMM-yyyy");

            System.out.printf("%s %s %s",
                    person.getName(),
                    person.getSex().equals(Sex.FEMALE) ? "ж" : "м",
                    dateFormat.format(person.getBirthDate()));
        } else if (args[0].equals("-c")) {
            Person person = null;

            if (args[2].equals("м")) {
                person = Person.createMale(args[1], dateFormat.parse(args[3]));
            } else if (args[2].equals("ж")) {
                person = Person.createFemale(args[1], dateFormat.parse(args[3]));
            } else {
                return;
            }

            allPeople.add(person);

            System.out.println(allPeople.indexOf(person));
        }else if (args[0].equals("-u")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));

            person.setName(args[2]);

            if (args[3].equals("м")) {
                person.setSex(Sex.MALE);
            } else if (args[3].equals("ж")) {
                person.setSex(Sex.FEMALE);
            } else {
                return;
            }

            person.setBirthDate(dateFormat.parse(args[4]));
        } else if (args[0].equals("-d")) {
            int id = Integer.parseInt(args[1]);
            Person person = allPeople.get(id);

            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);

            allPeople.set(id, person);
        }
    }
}
