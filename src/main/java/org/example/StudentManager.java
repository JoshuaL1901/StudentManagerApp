package org.example;

import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {

        // Declarations
        Scanner kb = new Scanner(System.in); // Scanner used for user inputs.
        Student[] students = new Student[100]; // An Array to keep track of how many students are stored.
        int studentCount = 0; // Keeps track of how many students have been stored.
        boolean running = true; // Controls the menu loop.

        // A simple while loop connecting to a switch case.
        while (running) {
            System.out.println("\nStudent Manager Menu: ");
            System.out.println("\nOption 1: Add Student");
            System.out.println("\nOption 2: View Student List");
            System.out.println("\nOption 3: Exit Programme");
            System.out.println("\nChoose an option shown above.");

            int choice = kb.nextInt();
            kb.nextLine();

            switch (choice) {

                case 1:

                case 2:

                case 3:

                default:
                    System.out.println("Please enter a valid option. Try again.");

            }
        }



        // Closing the Scanner when done to avoid resource leaks.
        kb.close();
    }
}