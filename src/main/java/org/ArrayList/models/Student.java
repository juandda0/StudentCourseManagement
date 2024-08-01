package org.ArrayList.models;

public class Student {

    //Atributes
    private String name;
    private int id;


    //Constructor
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    //To String method
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
