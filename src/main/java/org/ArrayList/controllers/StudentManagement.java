/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.ArrayList.controllers;

import org.ArrayList.models.Course;
import org.ArrayList.models.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages students and courses in a simulated environment.
 * Provides methods to add, remove, and list students and courses,
 * as well as to enroll students in courses.
 * <p>
 * This class demonstrates the use of lambda expressions in Java for filtering and processing collections.
 */
public class StudentManagement {

    // Simulate entities
    private List<Student> students;
    private List<Course> courses;

    /**
     * Constructs a new StudentManagement instance.
     * Initializes empty lists for students and courses.
     */
    public StudentManagement() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    /**
     * Adds a new student to the list.
     *
     * @param name The name of the student.
     * @param id   The unique identifier of the student.
     */
    public void add_students(String name, int id) {
        students.add(new Student(name, id));
        System.out.println("Student added: " + name);
    }

    /**
     * Removes a student from the list based on their unique identifier.
     * Uses a lambda expression to filter the list and remove the student.
     * <p>
     * The lambda expression used is: <code>student -> student.getId() == id</code>
     * This expression checks if the student's ID matches the provided ID.
     *
     * @param id The unique identifier of the student to remove.
     */
    public void remove_student_by_id(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    /**
     * Adds a new course to the list.
     *
     * @param name      The name of the course.
     * @param course_id The unique identifier of the course.
     */
    public void add_course(String name, int course_id) {
        courses.add(new Course(name, course_id));
    }

    /**
     * Enrolls a student in a course based on their unique identifiers.
     * Uses lambda expressions to find the student and course from the lists.
     * <p>
     * The lambda expressions used are:
     * <ul>
     *   <li><code>s -> s.getId() == student_id</code> to find the student.</li>
     *   <li><code>c -> c.getCurse_id() == course_id</code> to find the course.</li>
     * </ul>
     * If either the student or course is not found, a message is printed.
     *
     * @param student_id The unique identifier of the student.
     * @param course_id  The unique identifier of the course.
     */
    public void enroll_student_in_course(int student_id, int course_id) {

        Student student = students.stream()
                .filter(s -> s.getId() == student_id)
                .findFirst()
                .orElse(null);

        if (student == null) {
            System.out.println("Student not found with ID: " + student_id);
            return;
        }

        Course course = courses.stream()
                .filter(c -> c.getCurse_id() == course_id)
                .findFirst()
                .orElse(null);

        if (course == null) {
            System.out.println("Course not found with ID: " + course_id);
            return;
        }
        course.enroll_student(student);
    }

    /**
     * Lists all students currently in the system.
     * Prints a message if no students are found.
     */
    public void list_students() {
        if (students.isEmpty()) {
            System.out.println("No students found");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    /**
     * Lists all courses currently in the system.
     * Prints the name and ID of each course, and lists the students enrolled in each course.
     * Prints a message if no courses are found.
     */
    public void list_course() {
        if (courses.isEmpty()) {
            System.out.println("No courses found");
        } else {
            for (Course course : courses) {
                System.out.println(course.getName() + " (ID: " + course.getCurse_id() + ")");
                course.list_enrolled_estudents();
            }
        }
    }
}
