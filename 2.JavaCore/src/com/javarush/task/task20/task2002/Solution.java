package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);



            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User me = new User();
            me.setFirstName("Александр");
            me.setLastName("Захария");
            me.setBirthDate(dateFormat.parse("27/01/1986"));
            me.setMale(true);
            me.setCountry(User.Country.UKRAINE);

            User someOne = new User();
            someOne.setFirstName("Name");
            someOne.setCountry(User.Country.OTHER);

            javaRush.users.add(me);
            javaRush.users.add(new User());
            javaRush.users.add(someOne);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (loadedObject.equals(javaRush) && loadedObject.hashCode() == javaRush.hashCode()) {
                System.out.println("Равны");
            } else {
                System.out.println("Не равны");
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);

                String firstName = user.getFirstName();
                String lastName = user.getLastName();
                boolean isMale = user.isMale();
                Date birthDate = user.getBirthDate();
                User.Country country = user.getCountry();

                writer.write(firstName != null ? firstName : "null");
                writer.newLine();
                writer.write(lastName != null ? lastName : "null");
                writer.newLine();
                writer.write(isMale ? "true" : "false");
                writer.newLine();
                writer.write(birthDate != null ? String.valueOf(user.getBirthDate().getTime()) : "0");
                writer.newLine();
                writer.write(country != null ? country.name() : "null");

                if (i + 1 < users.size()){
                    writer.newLine();
                }
            }

            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {
                User user = new User();

                String line = reader.readLine();
                user.setFirstName(line.equals("null") ? null : line);

                line = reader.readLine();
                user.setLastName(line.equals("null") ? null : line);

                line = reader.readLine();
                user.setMale(line.equals("true") ? true : false);

                line = reader.readLine();
                user.setBirthDate(line.equals("0") ? null : new Date(Long.parseLong(line)));

                line = reader.readLine();
                user.setCountry(line.equals("null") ? null : User.Country.valueOf(line));

                users.add(user);
            }

            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
