package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }

        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student bestStudent = new Student("", 0, 0.0);

        for (Student student: students) {
            if (bestStudent.getAverageGrade() <= student.getAverageGrade()) {
                bestStudent = student;
            }
        }

        return bestStudent;
    }

    public Student getStudentWithMinAverageGrade() {
        Student worseStudent = new Student("", 0, Double.MAX_VALUE);

        for (Student student: students) {
            if (worseStudent.getAverageGrade() >= student.getAverageGrade()) {
                worseStudent = student;
            }
        }

        return worseStudent;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}