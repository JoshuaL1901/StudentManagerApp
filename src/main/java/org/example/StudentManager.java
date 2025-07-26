package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {

        // Declarations
        Scanner kb = new Scanner(System.in); // Scanner used for user inputs.
        Student[] students = new Student[100]; // An Array to keep track of how many students are stored.
        int studentCount = 0; // Keeps track of how many students have been stored.
        boolean running = true; // Controls the menu loop.





        // Closing the Scanner when done to avoid resource leaks.
        kb.close();
    }
}