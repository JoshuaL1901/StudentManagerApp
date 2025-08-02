package org.example;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StudentManager {

    public static void main(String[] args) {

        // Declarations
        Scanner kb = new Scanner(System.in); // Scanner used for user inputs.
        Student[] students = new Student[100]; // An Array to keep track of how many students are stored.
        boolean running = true; // Controls the menu loop.
        int studentCount = loadStudentsFromCSV(students); // Load students from CSV on startup.

        // A simple while loop connecting to a switch case.
        while (running) {

            System.out.println("\n*****Student Manager Menu:*****");
            System.out.println("Option 1: Add Student");
            System.out.println("Option 2: View Student List");
            System.out.println("Option 3: Search Student");
            System.out.println("Option 4: Delete Student");
            System.out.println("Option 5: Exit Program");
            System.out.println("Choose an option shown above.");

            String input = kb.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue; // Goes back to the top of the while loop.
            }

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
                    saveStudentsToCSV(students, studentCount);
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
                    saveStudentsToCSV(students, studentCount);
                    break;

                // Case 5 is used to exit the program.
                case 5:

                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    saveStudentsToCSV(students, studentCount);
                    break;

                default:
                    System.out.println("Please enter a valid option. Try again.");

            }

        }

        // Closing the Scanner when done to avoid resource leaks.
        kb.close();

    }

    public static void saveStudentsToCSV(Student[] students, int studentCount) {
        try (FileWriter fw = new FileWriter("students.csv")) {
            for (int i = 0; i < studentCount; i++) {
                Student s = students[i];
                fw.write(s.getFirstName() + "," + s.getLastName() + "," + s.getAge() + "\n");
            }
            System.out.println("Students have been saved to students.csv successfully.");
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    public static int loadStudentsFromCSV(Student[] students) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            String line;
            while ((line = br.readLine()) != null && count < students.length) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String firstName = parts[0];
                    String lastName = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    students[count++] = new Student(firstName, lastName, age);
                }
            }
            System.out.println("Students have been loaded from students.csv successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No saved student data found (students.csv not found). Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
        return count;
    }

}