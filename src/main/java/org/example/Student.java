package org.example;

public class Student {

    private String firstName;
    private String lastName;
    private int age;


    // A constructor holding student information.
    public Student(String firstName, String lastName, int age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

    }

    // Constructors for getter methods.
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    // A constructor for displaying the student list.
    public String toString() {

        return " Name: " + firstName + " " + lastName + ", Age: " + age;

    }
}
