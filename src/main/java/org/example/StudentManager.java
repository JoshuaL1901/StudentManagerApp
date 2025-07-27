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

            System.out.println("\n*****Student Manager Menu:*****");
            System.out.println("Option 1: Add Student");
            System.out.println("Option 2: View Student List");
            System.out.println("Option 3: Search Student");
            System.out.println("Option 4: Delete Student");
            System.out.println("Option 5: Exit Program");
            System.out.println("Choose an option shown above.");

            int choice = kb.nextInt();
            kb.nextLine();

            switch (choice) {

                // Case 1 is asking for Student Information.
                case 1:

                    if(studentCount < students.length) {

                        System.out.println("Enter student first name: ");
                        String firstName = kb.nextLine();
                        System.out.println("Enter student last name: ");
                        String lastName = kb.nextLine();

                        int age = 0;
                        boolean validAge = false;
                        while (!validAge) { // A while loop to check that the user enters a valid age.
                            System.out.println("Enter student age: ");
                            if (kb.hasNextInt()) {
                                age = kb.nextInt();
                                kb.nextLine();
                                if (age >= 1 && age <= 100) { // Checks that the user age is between 1 and 100.
                                    validAge = true;
                                }else{
                                    System.out.println("Please enter a valid age.");
                                }
                            }else{
                                System.out.println("Please enter a number.");
                                kb.nextLine();
                            }
                        }

                        students[studentCount] = new Student(firstName, lastName, age);
                        studentCount++;

                        System.out.println("Student information added successfully.");

                    }else{
                        System.out.println("Student list is full.");
                    }
                    break;

                // Case 2 checks how many students there are and displays a list of all students entered.
                case 2:

                    if (studentCount == 0) { // If there are 0 students, will display the next line.
                        System.out.println("No students have been added yet.");
                    }else{ // If there are students, will display the student list.
                        System.out.println("Student List: "); // Displays student list.
                        for (int i = 0; i < studentCount; i++) {
                            System.out.println((i + 1) + "." + students[i]);
                        }
                    }
                    break;

                // Case 3 is used to search for a student using their first name or last name.
                case 3:

                    System.out.println("Enter the students first name or last name to search: ");
                    String searchName = kb.nextLine();
                    boolean found = false;

                    for (int i = 0; i < studentCount; i++) {
                        if (students[i].getFirstName().equalsIgnoreCase(searchName) ||
                                students[i].getLastName().equalsIgnoreCase(searchName) ) {
                            System.out.println("Student found: " + students[i]);
                            found = true;
                            break;
                        }
                    }

                if (!found) {
                    System.out.println("Student not found.");
                }
                break;

                // Case 4 is used to delete a student using their first name or last name.
                case 4:

                    System.out.println("Enter the students first name or last name to delete: ");
                    String deleteName = kb.nextLine();
                    boolean deleted = false;

                    for (int i = 0; i < studentCount; i++) {
                        if (students[i].getFirstName().equalsIgnoreCase(deleteName) ||
                                students[i].getLastName().equalsIgnoreCase(deleteName) ) {

                            for (int j = i; j < studentCount - 1; j++) {
                                students[j] = students[j + 1];
                            }

                            students[studentCount - 1] = null; // Clear the last element.
                            studentCount--;
                            deleted = true;
                            System.out.println("Student deleted successfully.");
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("No student found with that name.");
                    }
                    break;

                // Case 5 is used to exit the program.
                case 5:

                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Please enter a valid option. Try again.");

            }
        }

        // Closing the Scanner when done to avoid resource leaks.
        kb.close();

    }

    /*
     CVS code TODO

    public static void saveStudentsToCSV(Student[] students, int studentCount) {

    }

    public static int loadStudentsFromCSV(Student[] students) {

    }

     */

}