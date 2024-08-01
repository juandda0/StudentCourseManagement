package org.ArrayList.main;

import org.ArrayList.controllers.StudentManagement;

import java.util.Scanner;

//This class is just for practice with ArrayList!
public class Main {

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student by ID");
            System.out.println("3. Add Course");
            System.out.println("4. Enroll Student in Course");
            System.out.println("5. List Students");
            System.out.println("6. List Courses");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    management.add_students(name, id);
                    break;
                case 2:
                    System.out.print("Enter student ID to remove: ");
                    int removeId = scanner.nextInt();
                    management.remove_student_by_id(removeId);
                    break;
                case 3:
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter course ID: ");
                    int courseId = scanner.nextInt();
                    management.add_course(courseName, courseId);
                    break;
                case 4:
                    System.out.print("Enter student ID to enroll: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter course ID to enroll in: ");
                    int enrollCourseId = scanner.nextInt();
                    management.enroll_student_in_course(studentId, enrollCourseId);
                    break;
                case 5:
                    management.list_students();
                    break;
                case 6:
                    management.list_course();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);

        scanner.close();
    }
}