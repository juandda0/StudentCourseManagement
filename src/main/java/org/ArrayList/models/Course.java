package org.ArrayList.models;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String name;
    private int curse_id;

    private List <Student> enrolled_students;

    public Course(String name, int curse_id) {
        this.name = name;
        this.curse_id = curse_id;
        enrolled_students = new ArrayList<>();
    }

    public void enroll_student(Student student){
        enrolled_students.add(student);
        System.out.println("Student " + student.getName() + " enrolled in course " + name);
    }

    public void list_enrolled_estudents(){
        if(enrolled_students.isEmpty()){
            System.out.println("No students found ");
        }else{
            for(Student student : enrolled_students){
                System.out.println(student);
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getCurse_id() {
        return curse_id;
    }

    public List<Student> getEnrolled_students() {
        return enrolled_students;
    }

}
