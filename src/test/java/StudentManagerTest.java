package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentManagerTest {

    @Test
    public void testStudentConstructorAndGetters() {
        Student student = new Student("Alice", "Smith", 22);

        assertEquals("Alice", student.getFirstName());
        assertEquals("Smith", student.getLastName());
        assertEquals(22, student.getAge());
    }

    @Test
    public void testSaveAndLoadStudentsCSV() {
        Student[] students = new Student[2];
        students[0] = new Student("John", "Doe", 20);
        students[1] = new Student("Jane", "Doe", 21);

        StudentManager.saveStudentsToCSV(students, 2);

        Student[] loadedStudents = new Student[2];
        int loadedCount = StudentManager.loadStudentsFromCSV(loadedStudents);

        assertEquals(2, loadedCount);
        assertEquals("John", loadedStudents[0].getFirstName());
        assertEquals("Jane", loadedStudents[1].getFirstName());
    }
}
