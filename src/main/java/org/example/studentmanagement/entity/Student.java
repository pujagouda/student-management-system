package org.example.studentmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "students")

public class Student {

    @Id

    private int id;

    @NotBlank(message = "Name can't be empty")
    private String name;

    @Min(value = 15, message = "Age must be at least 15")
    @Max(value = 100, message = "Age must not exceed 100")
    private int age;

    @NotBlank(message = "Course can't be empty")
    private String course;

    @Min(value = 0, message = "Marks can't be negetive")
    @Max(value = 100, message = "Marks cannot exceed 100")
    private double marks;

    public Student(){

    }

    public Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", marks=" + marks +
                '}';
    }
}